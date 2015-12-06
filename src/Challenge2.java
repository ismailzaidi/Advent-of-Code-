import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Yusuf on 06/12/2015.
 */
public class Challenge2 {
    private ArrayList<String> listOFFeed;

    public Challenge2() {
        listOFFeed = new ArrayList<String>();
        readFile();
    }

    public void readFile() {
        File file = new File("text.txt");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = "";

            while ((line = reader.readLine()) != null) {

                listOFFeed.add(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //2*l*w + 2*w*h + 2*h*l
    public int calculateSquareFeed(int length, int width, int height) {
        return ((2 * length * width) + (2 * width * height) + (2 * height * length)) + (length * width);
    }

    public ArrayList<Integer> getSmallestValue(String input) {
        String[] items = input.split("x");
        int length = Integer.parseInt(items[0]);
        int width = Integer.parseInt(items[1]);
        int height = Integer.parseInt(items[2]);
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(length);
        list.add(width);
        list.add(height);
        Collections.sort(list);
        return list;
    }

    public int processString(String feet, int position) {

        return Integer.parseInt(feet.split("x")[position]);
    }
    public int calculateRibon(int length,int width, int height){
        return (int) ((length+length) + (width+width)) + (length*width*height);
    }
    public void generateResult() {
        int globalSum = 0;
        int ribonSum =0;
        for(String feet: listOFFeed){
            ArrayList<Integer> array_calculation = getSmallestValue(feet);
            int length = array_calculation.get(0);
            int width = array_calculation.get(1);
            int height = array_calculation.get(2);
            int squarefeet = calculateSquareFeed(length,width,height);
            int totalRibon = calculateRibon(length,width,height);
            ribonSum+=totalRibon;
            globalSum += squarefeet;
        }
        System.out.println("The Elf Require this amount of square feet: " + globalSum);
        System.out.println("The Elf Require this amount of square feet for Ribon " + ribonSum);
    }

    public static void main(String[] args) {
        new Challenge2().generateResult();
    }
}
