package com.shiwang.DSA;

import java.io.*;
import java.util.*;

public class VotingResult {
    public static Map<String,Integer> processData(ArrayList<String> array) {


        int i=0;
        ArrayList<Main.ConsData> candList= new ArrayList<>();
        while(i<array.size()){
            String[] values= array.get(i).replaceAll("\\s","").split(",");
            int cId=Integer.parseInt(values[0]);
            int votes=Integer.parseInt(values[3]);
            String constituency=values[2];

            candList.add(new Main.ConsData(cId,votes,constituency));
            i++;
        }
        int AmaxVotes=0;
        int BmaxVotes=0;

        Map<String,Integer> retVal = new TreeMap<>();
        for(Main.ConsData candidate: candList){

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

            for(Map.Entry<String,Integer> e: retVal.entrySet())
                System.out.println(e.getKey() + " : " + e.getValue());
        } catch (IOException e) {
            System.out.println("IO error in input.txt or output.txt");
        }
    }
}
