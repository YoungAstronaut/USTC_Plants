package com.example.ustcplant;

import java.io.Serializable;

public class Plant implements Serializable {
    private int index;
    private int nameId;
    private int nicknameId;
    private int speciesId;
    private int featureId;
    private int valuesId;
    private int locationId;
    private int supplementId;
    private int image_num;//“该种植物图片的数量”
    private int imageIDs;

    public Plant(int index, int nameId, int nicknameId, int speciesId, int featureId,
                 int valuesId, int locationId, int supplementId, int imageIDs){
        this.index = index;
        this.nameId = nameId;
        this.nicknameId = nicknameId;
        this.speciesId = speciesId;
        this.featureId = featureId;
        this.valuesId = valuesId;
        this.locationId = locationId;
        this.supplementId = supplementId;
        this.imageIDs = imageIDs;

    }
    public int getIndex(){
        return this.index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getName(){
        return this.nameId;
    }

    public void setNameId(int nameId) {
        this.nameId = nameId;
    }

    public int getNickname(){
        return this.nicknameId;
    }

    public void setNicknameId(int nicknameId) {
        this.nicknameId = nicknameId;
    }

    public int getSpecies(){
        return this.speciesId;
    }

    public void setSpeciesId(int speciesId) {
        this.speciesId = speciesId;
    }

    public int getFeature(){
        return this.featureId;
    }

    public void setFeatureId(int featureId) {
        this.featureId = featureId;
    }

    public int getValues(){
        return this.valuesId;
    }

    public void setValuesId(int valuesId) {
        this.valuesId = valuesId;
    }

    public int getLocation(){
        return this.locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public int getSupplement(){
        return this.supplementId;
    }

    public void setSupplementId(int supplementId) {
        this.supplementId = supplementId;
    }

    public int getImageIDs(){
        return imageIDs;
    }

    public void setImageIDs(int imageIDs) {
        this.imageIDs = imageIDs;
    }

    public int getImage_num() {
        return this.image_num;
    }

    public void setImage_num(int image_num) {
        this.image_num = image_num;
    }

}
