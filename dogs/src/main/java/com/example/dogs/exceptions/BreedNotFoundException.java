package com.example.dogs.exceptions;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.HashMap;
import java.util.List;

public class BreedNotFoundException extends RuntimeException implements GraphQLError {

    private HashMap<String ,Object> extensions = new HashMap<>();

    public  BreedNotFoundException(String msg,String invalidBreed){
        super(msg);
        extensions.put("invalidBreed",invalidBreed);
    }
    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public ErrorType getErrorType() {
        return null;
    }
}
