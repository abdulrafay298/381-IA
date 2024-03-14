package edu.ucalgary.oop;

import java.util.HashSet;
import java.util.Set;

public class FamilyRelation {
    private DisasterVictim personOne;
    private String relationshipTo;
    private DisasterVictim personTwo;
    private static Set<FamilyRelation> existingRelationships = new HashSet<>();

    public FamilyRelation(DisasterVictim personOne, String relationshipTo, DisasterVictim personTwo) {
        this.personOne = personOne;
        this.relationshipTo = relationshipTo;
        this.personTwo = personTwo;
    }

    public DisasterVictim getPersonOne() {
        return personOne;
    }

    public void setPersonOne(DisasterVictim personOne) {
        this.personOne = personOne;
    }

    public String getRelationshipTo() {
        return relationshipTo;
    }

    public void setRelationshipTo(String relationshipTo) {
        this.relationshipTo = relationshipTo;
    }

    public DisasterVictim getPersonTwo() {
        return personTwo;
    }

    public void setPersonTwo(DisasterVictim personTwo) {
        this.personTwo = personTwo;
    }

    public boolean isValidRelationship() {
        
        return personOne != null && personTwo != null && relationshipTo != null && !relationshipTo.isEmpty();
    }

    public boolean isDuplicateRelationship() {
        for (FamilyRelation existingRelationship : existingRelationships) {
            if (existingRelationship.getPersonOne().equals(this.getPersonOne()) &&
                existingRelationship.getRelationshipTo().equals(this.getRelationshipTo()) &&
                existingRelationship.getPersonTwo().equals(this.getPersonTwo())) {
                return true;
            }
        }
        return false;
    }

    public static boolean addRelationship(DisasterVictim personOne, String relationshipTo, DisasterVictim personTwo) {
        FamilyRelation newRelation = new FamilyRelation(personOne, relationshipTo, personTwo);
        if (newRelation.isValidRelationship() && !newRelation.isDuplicateRelationship()) {
            existingRelationships.add(newRelation);
            return true;
        }
        return false;
    }
}
