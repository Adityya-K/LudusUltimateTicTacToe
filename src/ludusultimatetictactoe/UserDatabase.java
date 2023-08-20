package ludusultimatetictactoe;

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
    private String USER_DATABASE_FILE_PATH = "userDatabase.txt";
    private String userDatabaseEncryptionKey = config.userDataBaseEncryptionKey;

    public ArrayList<User> getUserDatabase() {
        return userDatabase;
    }
    private ArrayList<User> userDatabase = new ArrayList<>();
    
    // loads the database from the file, returns done if done
    public String loadDatabase() {
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
        fileData.replaceAll("[\n\r]$", "");
        // check if empty string or .trim() is empty
        if(fileData == null || fileData.trim().isEmpty()) {
            return "done";
        }
        
        // decrypted database
        String decrypted = decryptDataBase(fileData);
        
        // spilt the decrypted database into an array of user strings
        String [] users = decrypted.split(System.lineSeparator());
        for (String userString: users) {
            System.out.println(userString);
            User currentUser = new User(userString);
            userDatabase.add(currentUser);
        }
        
        return "done";
    }
    
    public User getUser(String userName, String password) {
        // perform linear search on user database.
        // todo hash maps instead
        for (User user: userDatabase) {
            if (user.getUsername().equals(userName)) {
                String inputEncryptedPassword = SHAEncryption.getSHA256Hash(password);
                // check if the encrypted input password is equal to the actual user password
                if (user.getEncryptedPassword().equals(inputEncryptedPassword)) {
                    return user;
                }
            }
        }
        // otherwise return null.
        return null;
    }
    
    // also saves the user DB
    public User addUser(String userName, String password) {
        User newUser = new User(userName, password);
        userDatabase.add(newUser);
        saveUserDatabase(userDatabase);
        return newUser;
        
    }

    public UserDatabase() {
    }
    
    public void saveUserDatabase(ArrayList<User> users) {
        String fileData = "";
        
        for (User user: users) {
            fileData += user.toString() + "\n";
        }
        // use regext to remove the final newline
        fileData.replaceAll("[\n\r]$", "");
        
        String encryptedFile = encryptDataBase(fileData);
        
        try {
            System.out.println("Saving file");
            BufferedWriter writer = new BufferedWriter(new FileWriter(USER_DATABASE_FILE_PATH));
            writer.write(encryptedFile);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String decryptDataBase (String encryptedDatabase) {
        AESEncryption aes = new AESEncryption();
        String decryptedDatabase = aes.decrypt(encryptedDatabase, userDatabaseEncryptionKey);
        return decryptedDatabase;
    }
    
    public String encryptDataBase (String database) {
        AESEncryption aes = new AESEncryption();
        String encryptedDatabase = aes.encrypt(database, userDatabaseEncryptionKey);
        return encryptedDatabase;
    }
}
