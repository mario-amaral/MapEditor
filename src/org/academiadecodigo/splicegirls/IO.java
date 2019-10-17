package org.academiadecodigo.splicegirls;

import java.io.*;

public class IO {

    private String saveFile;
    private FileReader inFile;
    private FileWriter outFile;

    private String states;

    private int cols;
    private int rows;

    public IO(String saveFile, int cols, int rows){
        this.saveFile = saveFile;
        this.cols =cols;
        this.rows=rows;
    }

    public String getStates() {
        return states;
    }

    public void save(String[] states) throws IOException {
        outFile = new FileWriter(saveFile);
        BufferedWriter bufferedWriter = new BufferedWriter(outFile);

        try{
            for (int j = 0; j<rows; j++){
                bufferedWriter.write(states[j]);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            bufferedWriter.close();
        }
    }

    public String[] load() throws IOException {
        inFile = new FileReader(saveFile);
        BufferedReader bufferedReader = new BufferedReader(inFile);
        String[] result = new String[rows];
        for(int j=0; j<rows; j++){
            result[j] = "";
        }

        try{
            int j=0;
            while(bufferedReader.readLine() != null ){
                result[j++] += bufferedReader.readLine();
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            bufferedReader.close();
        }
        return result;
    }
}
