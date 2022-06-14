package com.example.frituurfrida.repositories;

import com.example.frituurfrida.domain.Saus;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
@Qualifier("Properties")
public class PropertiesSausRepository implements SausRepository{

    @Override
    public List<Saus> findAll() {
        String file = "/data/sauzen.properties";
        List<Saus> sausLijst = new ArrayList<>();
        try(var bufferedReader = new BufferedReader(new FileReader(file))){
            String line;
            while ((line = bufferedReader.readLine()) != null){
                var splitLine = line.split("[:,]");
                var ingredienten = Arrays.copyOfRange(splitLine,2,splitLine.length);
                sausLijst.add(new Saus(Integer.parseInt(splitLine[0]),splitLine[1],ingredienten));
            }
        } catch (IOException e){
            System.err.println(e.getMessage());
        }
        return sausLijst;
    }
}
