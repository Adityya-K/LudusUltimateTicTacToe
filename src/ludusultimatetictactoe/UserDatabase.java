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


public class UserDatabase {
    private String USER_DATABASE_FILE_PATH = "userDatabase.txt";
    private String userDatabaseEncryptionKey = config.userDataBaseEncryptionKey;
    private ArrayList<User> userDatabase = new ArrayList<>();

    public ArrayList<User> loadDatabase() {
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
        
        // decrypted database
        String decrypted = decryptDataBase(fileData);
        
        // spilt the decrypted database into an array of user strings
        String [] users = decrypted.split(System.lineSeparator());
        
        for (String userString: users) {
            User currentUser = new User(userString);
            userDatabase.add(currentUser);
        }
        
        return userDatabase;
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
