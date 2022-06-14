package com.example.frituurfrida.repositories;

import com.example.frituurfrida.domain.Saus;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class CSVSausRepository {

    public List<Saus> findAll(){
        List<Saus> sausLijst = new ArrayList<>();
        String file = "/data/sauzen.csv";
        try(var br = new BufferedReader(new FileReader(file))){
            String line;
            while ((line = br.readLine()) != null){
                var splitLine = line.split(",");
                var ingredienten = Arrays.copyOfRange(splitLine,2,splitLine.length);
                sausLijst.add(new Saus(Integer.parseInt(splitLine[0]),splitLine[1],ingredienten));
            }
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
        return sausLijst;
    }
}
