/*
 * Group Name: Ludus 
 * Members: Adityya Kaushal, Alexander Tan, Eksjot Multani, Owen Yang
 * ICS4UE
 * August 20-22, 2023
 * Mr. Diakoloukas
 * Purpose: store info about user database information
 * 
 */

package user;

import user.config;
import java.io.*;
import java.util.*;

/*
Database file:
value1,2,3,4,5
value6,7,8,9,10 ...

*/

/*
username,encryptedPassword,rating,wins,losses,currentGame,gamesPlayed,dateJoined
*/

// need to user .loadDatabase(); before adding user
public class UserDatabase {
    private static String USER_DATABASE_FILE_PATH = "userDatabase.txt";
    private static String USER_DATABASE_ENCRYPTION_KEY = config.USER_DATABASE_ENCRYPTION_KEY;

    public static ArrayList<User> getUsers() {
        return users;
    }
    private static ArrayList<User> users = new ArrayList<>();
    
    
    // loads the database from the file, returns done if done
    public static String loadDatabase() {
        // case where user dtabase is alreayd loaded;
        if (users.size() > 0){
            return "done";
        }
        String fileData = "";
        try{
            BufferedReader reader = new BufferedReader(new FileReader(USER_DATABASE_FILE_PATH));
            String line;
            while ((line = reader.readLine()) != null) {
                // database will be an ecyrpted string without newlines, so don't add newline at end of line.
                // base64 encoded AES string
                fileData += line;
            }
            reader.close();

        } catch (IOException e){
            e.printStackTrace();
        }
        
        // remove all newlines from end of file
        fileData = fileData.trim();
        // check if empty string or .trim() is empty
        if(fileData == null || fileData.trim().isEmpty()) {
            return "done";
        }

        
        // decoded database
        String decoded = decodeDatabase(fileData);
        // spilt the decoded database into an array of user strings
        String [] usersStrings = decoded.split("\n");
        // print list of users
        // print decoded


        // databse is stored as comma seperated user strings
        // e.g. user1, rating ...
        // create a new user from this.
        for (String userString: usersStrings) {
            // remove any whitespaces
            userString = userString.trim();
            // create a new user from the attributes
            User currentUser = new User(userString);
            // add current user to array list
            users.add(currentUser);
        }
        
        return "done";
    }
    
    public static User getUser(String userName, String password) {
        // perform linear search on user database.
        // todo hash maps instead
        for (User user: users) {
            if (user.getUsername().equals(userName)) {
                if (user.getPassword().equals(password)) {
                    return user;
                }
            }
        }
        // otherwise return null.
        return null;
    }
    
    // get user with only by username
    public static User getUser(String userName) {
        // perform linear search on user database.
        // todo hash maps instead
        for (User user: users) {
            if (user.getUsername().equals(userName)) {
                return user;
            }
        }
        // otherwise return null.
        return null;
    }
    
    // Check if user exists givne username
    public static boolean existsUser(String userName) {
        // perform linear search on user database.
        // todo hash maps instead
        for (User user: users) {
            // if username is equal to user's uesrname
            if (user.getUsername().equals(userName)) {
                // reutrn true
                return true;
            }
        }
        // otherwise return false.
        return false;
    }    
    // also saves the user DB
    public static User addUser(String userName, String password, String email) {
        // creaqte new user with addtributes
        User newUser = new User(userName, password, email);
        // add user to users array list
        users.add(newUser);
        // saves it
        saveUserDatabase(users);
        return newUser;
    }
    
    // empty constrctor for user database
    public UserDatabase() {
    }
    
    // get user by email returns the user with the email
    public static User getUserByEmail(String email) {
        // loop through each user 
        for (User user: users) {
            // check if email is == to requested email
            if (user.getEmail().equals(email)){
                // return the associated user
                return user;
            }
            
        }
        // otherwise return null
        return null;
    }
    // saves users after change
    // the user object is already updated
    // so save the user database with the current users list
    public static void saveUsers() {
        saveUserDatabase(users);
    }
    
    // save user database
    public static void saveUserDatabase(ArrayList<User> users) {
        // file data
        String fileData = "";
        // loop through each user
        for (User user: users) {
            // add user with newline
            fileData += user.toString() + "\n";
        }
        // output debug message

        fileData = fileData.trim();
        
        // encrypt the database with base64
        String encodedFile = encodeDatabase(fileData);
        // attempt ot save file
        try {
            // user buffered writer on the DATABASE_FILE_PATH
            BufferedWriter writer = new BufferedWriter(new FileWriter(USER_DATABASE_FILE_PATH));
            // write to file with encoded file contents
            writer.write(encodedFile);
            // close the writer
            writer.close();
        } catch (IOException e) {
            // hyandle IO exceptions
            e.printStackTrace();
        }
        // Saving unencoded file for debugging purposes:
        try {
            // print saving file
            // buffered write on the un encoded database
            BufferedWriter writer = new BufferedWriter(new FileWriter("unencodedDatabase.txt"));

            // write on the filedata
            writer.write(fileData);
            // close writer
            writer.close();
        } catch (IOException e) {
            // catch IO exception and print stakc trace
            e.printStackTrace();
        }
    }
    
    // get top players
    public static ArrayList<User> getTopPlayers() {
        // quicksort the top players
        // clone the users array
        ArrayList<User> topPlayers =(ArrayList) users.clone();
        
        // quicksort
        quickSortByRating(topPlayers, 0, users.size() - 1);
        return topPlayers;
    }
    
    // quick sort, by the "rating" attribute of each user
    // descending
    public static void quickSortByRating(ArrayList <User> arr, int lowIdx, int highIdx) {
       // continue quick sorting if the high Idx is greater than low idx.
        if (highIdx > lowIdx) {
            // set j as result of asc partion, index to seperate the paritions of array
            int j = partitionDesc(arr, lowIdx, highIdx);
            // quick sort recurisvely the left part of the array after partition
            quickSortByRating(arr, lowIdx, j - 1);
            // quick sort reucrisvely the right part of array;
            quickSortByRating(arr, j + 1, highIdx);
        }
        // otherwise, the sort is finished.        
    }

    // partition the array from  the lowIdx to high idx
    // use lowidx as pivot
    // returns an int j to
    public static int partitionDesc (ArrayList <User> arr, int lowIdx, int highIdx) {
        // set i as low index and j pointer as highIdx + 1
        int i = lowIdx;
        int j = highIdx + 1;
        // set pivot element as low idxth user rating
        double pivot = arr.get(lowIdx).getRating();
        // do while the lowIdx is smalelr than highIdx + 1
        do {
            // contionously add 1 to lowIdx (i) until the rating value if greater than the pivot value (makes i highest idx such that it is greater than pivot value)
            do {
                i += 1;
            } while (i <= highIdx && arr.get(i).getRating()> pivot);
            // subtract 1 to j until the value is smaller than pivot.
            do {
                j -= 1;
            } while (j >= lowIdx && arr.get(j).getRating() < pivot);
            // swap ith and jth value, if i is still smaller than j
            if (i < j) {
                swap(arr, i, j);
            }
        } while (i < j);
        // finally swap the low idx and the j value
        swap(arr,lowIdx,j);
        // return j value.
        return j;   
    }
    
    // swaps 2 indices i, j for intArr
    public static void swap(ArrayList<User> arr, int i, int j) {
        
        // temporarily store ith value
        User temp = arr.get(i);
        // i th value = j th value.
        arr.set(i, arr.get(j));
        // j value = previously stored ith value
        arr.set(j, temp);
    }
    
    // decrypt databse, takes in encrypted database
    public static String decodeDatabase (String encodedDatabase){ 
        // base64 decode the database;
        return new String(Base64.getDecoder().decode(encodedDatabase));
    }
    
    // encrypt the database
    public static String encodeDatabase (String database) {
        // return encoded database
        return new String(Base64.getEncoder().encode(database.getBytes()));
    }
}
