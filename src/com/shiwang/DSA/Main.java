package com.shiwang.DSA;



/*
 * Save this in a file called Main.java and compile it. To test it
 * create the file `input.txt` in the workspace / Working Directory
 * (For Eclipse/VisualStudio, by default this is the top level project folder)
 */

/* Do not add a package declaration */
import java.util.*;
import java.io.*;

/* DO NOT CHANGE ANYTHING ABOVE THIS LINE */
/* You may add any imports here, if you wish, but only from the
   standard library */

/* Do not add a namespace declaration */
public class Main {
    public static Map<String,Integer> processData(ArrayList<String> array) {
        /*
         * Modify this method to process `array` as indicated
         * in the question. At the end, return a Map containing
         * the appropriate values
         *
         * Please create appropriate classes, and use appropriate
         * data structures as necessary.
         *
         * Do not print anything in this method.
         *
         * Submit this entire program (not just this method)
         * as your answer
         */
        Map<ConsData,String > constituencyVotes= new HashMap<>();
        int i=0;
        ArrayList<ConsData> candList= new ArrayList<>();
        while(i<array.size()){
            String[] values= array.get(i).replaceAll("\\s","").split(",");
            int cId=Integer.parseInt(values[0]);
            int votes=Integer.parseInt(values[3]);
            String constituency=values[2];

            candList.add(new ConsData(cId,votes,constituency));
            i++;
        }
        int AmaxVotes=0;
        int BmaxVotes=0;

        Map<String,Integer> retVal = new TreeMap<>();
        for(ConsData candidate: candList){

            if(candidate.getArea().equals("Aundh") && candidate.getVotes()>AmaxVotes) {
                AmaxVotes=candidate.getVotes();
                retVal.put(candidate.getArea(),candidate.getCanId());
            }
            else if(candidate.getArea().equals("Baner") && candidate.getVotes()>BmaxVotes) {
                BmaxVotes=candidate.getVotes();
                retVal.put(candidate.getArea(),candidate.getCanId());
            }
        }

        return retVal;
    }

    static class ConsData{

        private int canId;
        private int votes;

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        private String area;

        ConsData(int cId, int Vo, String area){
            this.canId=cId;
            this.votes=Vo;
            this.area=area;
        }

        public int getCanId() {
            return canId;
        }

        public void setCanId(int canId) {
            this.canId = canId;
        }

        public int getVotes() {
            return votes;
        }

        public void setVotes(int votes) {
            this.votes = votes;
        }
    }

    public static void main (String[] args) {
        ArrayList<String> inputData = new ArrayList<String>();
        String line;
        try {
            Scanner in = new Scanner(new BufferedReader(new FileReader("C:\\Users\\shiwa\\IdeaProjects\\CodingChallenges\\src\\com\\shiwang\\DSA\\input.txt")));
            while(in.hasNextLine())
                inputData.add(in.nextLine());
            Map<String,Integer> retVal = processData(inputData);
            PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));
            for(Map.Entry<String,Integer> e: retVal.entrySet())
                output.println(e.getKey() + ": " + e.getValue());
            output.close();
        } catch (IOException e) {
            System.out.println("IO error in input.txt or output.txt");
        }
    }
}