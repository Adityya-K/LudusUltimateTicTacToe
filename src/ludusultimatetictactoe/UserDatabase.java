package ludusultimatetictactoe;

import java.io.*;

/*
Database file:
value1,2,3,4,5
value6,7,8,9,10 ...

*/

public class UserDatabase {
    private String USER_DATABASE_FILE_PATH = "userDatabase.txt";


    public void loadDatabase() {

        try{
            String fileData = "";
            BufferedReader reader = new BufferedReader(new FileReader(USER_DATABASE_FILE_PATH));
            String line;
            while ((line = reader.readLine()) != null) {
                fileData += (line += "\n");
            }

            reader.close();

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void decryptDataBase () {

    }


}
