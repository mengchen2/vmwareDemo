package com.symbio.skillsoft.dataobjects;

/**
 * This is a simple POJO (Plain Old Java Object) that represents the information that is stored
 * in the yaml files located @ src/test/resources/testdata/.
 */
public class UserInformation {

    private String language;

    public UserInformation () {
    	 this.setLanguage("english");
    }

    public UserInformation(String language) {
        this.setLanguage(language);
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString () {
        return "Language: " + language;
    }

}
