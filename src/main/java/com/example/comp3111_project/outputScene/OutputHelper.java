package com.example.comp3111_project.outputScene;

import com.example.comp3111_project.Algorithms.Person;
import com.example.comp3111_project.Algorithms.Team;
import com.example.comp3111_project.HelloApplication;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;

public class OutputHelper{


    private  List<String> nameList = new ArrayList<>();

    private  String foundNameResult ;

    private   String foundIDResult ;

    private  String teamId;

    private  String K1Average;

    private  String K2Average;

    private Team[] teamArray;



    //private Object[] teamList = new Object[4];

    public OutputHelper(Team[] team){
        this.teamArray = team;
    }
    public  int checkForValidInput(String search){
        if (search.matches("[0-9]+")){
            if (search.length() !=8) {
                return -1;
            }
           return checkForExistingStudentID(search);
        }
        if (checkForFormat(search)==1){
            return checkForExistingStudentName(search);
        }
        return -1;
    }

    public int checkForExistingStudentID(String search){
        System.out.println("__________________________");
        for (Team team: teamArray) {
            System.out.println(team);
            for (Person student : team.getStudentList()) {
                if (student!=null){
                    if (student.getStudentid().compareTo(search)==0 ) {
                        teamId = String.valueOf(team.getID());
                        K1Average = String.format("%.2f",team.getK1());
                        K2Average = String.format("%.2f",team.getK2());
                        foundIDResult = search;
                        for (Person teamStudent:team.getStudentList())
                        {
                            if (teamStudent!=null){
                                if (teamStudent.getStudentid().compareTo(search)==0 ) {
                                    foundNameResult = teamStudent.getStudentname();

                                }
                                nameList.add(teamStudent.getStudentname());
                            }
                        }
                        return 1;
                    }
                }
            }
        }
        return 0;
    }

    public int checkForExistingStudentName(String search){
        for (Team team: teamArray) {
            for (Person student : team.getStudentList()) {
                if (student!=null){
                    System.out.println(student.getStudentname());
                    if (student.getStudentname().compareTo(search) == 0) {
                        teamId = String.valueOf(team.getID());
                        K1Average = String.format("%.2f",team.getK1());
                        K2Average = String.format("%.2f",team.getK2());
                        foundNameResult = search;
                        for (Person teamStudent:team.getStudentList())
                        {
                            if (teamStudent!=null) {
                                if (teamStudent.getStudentname().compareTo(search) == 0) {
                                    foundIDResult = teamStudent.getStudentid();
                                }
                                nameList.add(teamStudent.getStudentname());
                            }
                        }

                        return 1;
                    }
                }
            }
        }
        return 0;
    }

    /**
     * check for valid input
     * @param search check the inputField whether it is valid format
     * @return -1 for invalid format 1 for valid format
     */

    public  int checkForFormat(String search){
        List<String> stringList = new ArrayList<>();
        char[] charSearch = search.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<charSearch.length;i++) {
            if (charSearch[i]==' ') {
                stringList.add(sb.toString());
                sb.setLength(0);
                if (charSearch[i]==' ') {
                    continue;
                }
                sb.append(charSearch[i]);
                continue;
            }
            if (i==charSearch.length-1) {
                sb.append(charSearch[i]);
                stringList.add(sb.toString());
            }
            sb.append(charSearch[i]);
        }
        if (stringList.size()!=2) {
            return -1;
        }
        else {
            if (!stringList.get(0).matches("[a-zA-Z]+")) {
                return -1;
            }
            if (!stringList.get(1).matches("[a-zA-Z]+")) {
                return -1;
            }
            return 1;
        }
    }

    public List<String> getNameList(){
        return  nameList;
    }

    public String getK1Average(){
        return K1Average;
    }

    public String getK2Average(){
        return K2Average;
    }

    public String getFoundNameResult(){
        return foundNameResult;
    }

    public String getFoundIDResult(){
        return foundIDResult;
    }

    public String getTeamId(){
        return teamId;
    }
}
