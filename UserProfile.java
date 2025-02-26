/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.socialnet;
import java.util.Iterator;


class UserProfile {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private LList<String> friends;

    public UserProfile(String fName, String lName, String emailAddr, String phoneNum) {
        firstName = fName;
        lastName = lName;
        email = emailAddr;
        phone = phoneNum;
        friends = new LList<>();
    }

    public String getEmail() {
        return email;
    }

    public void addFriend(String friendEmail) {
        friends.add(friendEmail);
    }

    public void removeFriend(String friendEmail) {
        // friends.remove(friendEmail);
        int i = 1;
        for (String friend : getFriendsList()) {
            if (friend.equals(friendEmail)) {
                friends.remove(i);
                break;
            }
            i += 1;
        }
    }
    
    public String[] getFriendsList() {
        String[] friendsArray = new String[friends.getLength()];
        return friends.toArray(friendsArray);
    }

    public void modifyProfile(String fName, String lName, String emailAddr, String phoneNum) {
        if (firstName != null) firstName = fName;
        if (lastName != null) lastName = lName;
        if (email != null) email = emailAddr;
        if (phone != null) phone = phoneNum;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " (" + email + ", " + phone + ") - Friends: " + friends;
    }
}

class SocialNetwork implements DictionaryInterface<String, UserProfile> {
    private LinkedDictionary<String, UserProfile> profiles;

    public SocialNetwork() {
        profiles = new LinkedDictionary<>();
    }

    @Override
    public UserProfile add(String email, UserProfile profile) {
        return profiles.add(email, profile);
    }

    @Override
    public UserProfile remove(String email) {
        UserProfile profile = profiles.remove(email);
        // Iterator<String> keyIterator = profiles.getKeyIterator();
        // Iterator<String> valueIterator = profiles.getValueIterator();
        // if (profile != null) {
            //     for (Iterator<String> friendEmail : profiles.getKeyIterator()) {
                //         UserProfile friendProfile = profiles.getValue(friendEmail);
                //         if (friendProfile != null) {
                    //             friendProfile.removeFriend(email);
                    //         }
                    //     }
                    // }

        // Remove this user from all friends' friend lists
        for (String friend : profile.getFriendsList()) {
            UserProfile friendProfile = profiles.getValue(friend);
            if (friendProfile != null) {
                friendProfile.removeFriend(email);
            }
        }
        return profile;
    }

    @Override
    public UserProfile getValue(String email) {
        return profiles.getValue(email);
    }

    @Override
    public boolean contains(String email) {
        return profiles.contains(email);
    }

    @Override
    public Iterator<String> getKeyIterator() {
        return profiles.getKeyIterator();
    }

    @Override
    public Iterator<UserProfile> getValueIterator() {
        return profiles.getValueIterator();
    }

    @Override
    public boolean isEmpty() {
        return profiles.isEmpty();
    }

    @Override
    public int getSize() {
        return profiles.getSize();
    }

    @Override
    public void clear() {
        profiles.clear();
    }

    public void displayProfiles() {
        // for (Iterator<String> profile : profiles.getKeyIterator()) {
        //     System.out.println(profile);
        // }
        Iterator<UserProfile> valueIterator = profiles.getValueIterator();
        while (valueIterator.hasNext()) {
            UserProfile profile = valueIterator.next();
            System.out.println(profile);
        }
    }

}
