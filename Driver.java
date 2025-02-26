/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.socialnet;
import java.util.Iterator;

/** 
   A driver that demonstrates the class LinkedDictionary.
   
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 4.0
*/
public class Driver
{
    
        public static void main(String[] args) {
		testSocialNetwork();
		System.out.println("\n\nDone.");

        }
	
	public static void testSocialNetwork()
	{
                // Create a dictionary 
                DictionaryInterface<String, UserProfile> profiles = new LinkedDictionary<>();
                ListInterface<String> emailList = new LList<>();
                
                // Users
                String johnEmail = "john@example.com";
                String janeEmail = "jane@example.com";
                String tomEmail = "tom@example.com";
                String dirkEmail = "dirk@example.com";
                String matEmail = "mat@example.com";
                String bobEmail = "bob@example.com";
                String charlieEmail = "charlie@example.com";
                String jimEmail = "jim@example.com";
                String maryEmail = "mary@example.com";
                String martinEmail = "martin@example.com";

                System.out.println("Create a dictionary:\n");
                System.out.println("Initial dictionary should be empty; isEmpty() returns " + 
                                        profiles.isEmpty());
                
                // Create a social network object
                SocialNetwork network = new SocialNetwork();
                
                // Create user profiles
                UserProfile p1 = new UserProfile("John", "Doe", johnEmail, "1234567890");
                UserProfile p2 = new UserProfile("Jane", "Smith", janeEmail, "0987654321");
                UserProfile p3 = new UserProfile("Thomas", "Jefferson", tomEmail, "135790246");
                UserProfile p4 = new UserProfile("Dirk", "Mayer", dirkEmail, "5556781212");
                UserProfile p5 = new UserProfile("Matthew", "Jhonson", matEmail, "8007001234");
                UserProfile p6 = new UserProfile("Bob", "Barker", bobEmail, "717123555");
                UserProfile p7 = new UserProfile("Charlie", "Jones", charlieEmail, "6157771223");
                UserProfile p8 = new UserProfile("Jim", "Jhonson", jimEmail, "9809991675");
                UserProfile p9 = new UserProfile("Mary", "Hart", maryEmail, "9199268877");
                UserProfile p10 = new UserProfile("Martin", "Hunter", martinEmail, "9867781243");


                // Add to the network
                network.add(johnEmail, p1);
                network.add(janeEmail, p2);
                network.add(tomEmail, p3);
                network.add(dirkEmail, p4);
                network.add(matEmail, p5);
                network.add(bobEmail, p6);
                network.add(charlieEmail, p7);
                network.add(jimEmail, p8);
                network.add(maryEmail, p9);
                network.add(martinEmail, p10);


                // Create friends list
                p1.addFriend(janeEmail);
                p2.addFriend(johnEmail);
                p3.addFriend(dirkEmail);
                p4.addFriend(bobEmail);
                p5.addFriend(jimEmail);
                p6.addFriend(johnEmail);
                p7.addFriend(martinEmail);
                p8.addFriend(maryEmail);
                p9.addFriend(charlieEmail);
                p10.addFriend(matEmail);

                p1.addFriend(dirkEmail);
                p2.addFriend(johnEmail);
                p3.addFriend(bobEmail);
                p4.addFriend(bobEmail);
                p5.addFriend(maryEmail);
                p6.addFriend(maryEmail);
                p7.addFriend(martinEmail);
                p8.addFriend(martinEmail);
                p9.addFriend(matEmail);
                p10.addFriend(maryEmail);

                network.displayProfiles();

                p1.modifyProfile("John", "Doe", "john@example.com", "1112223333");
                
                // Test add
                System.out.println("\n\nTesting add():\n");
                UserProfile p11 = new UserProfile("Judy", "Janice", "judy@example.com", "2123335467");
                UserProfile p12 = new UserProfile("Janet", "Huang", "janet@example.com", "7876541212");
                UserProfile p13 = new UserProfile("Jackie", "Chan", "tom@example.com", "9334441256");
                UserProfile p14 = new UserProfile("Jimmy", "George", "tom@example.com", "8772331212");
                UserProfile p15 = new UserProfile("Thomas", "Murphy", "tom@example.com", "9881223654");
                profiles.add("judy@example.com",   p12);
                profiles.add("janet@example.com",   p13);
                profiles.add("jackie@example.com",   p14);
                profiles.add("jimmy@example.com",   p15);

                System.out.println(network.getSize() + " (should be 11) items in dictionary, as follows:\n");
                network.displayProfiles();
                // display(emailList);
                
                // Test getValue
                System.out.println("\n\nTesting getValue():\n");
                System.out.println("\n John:   " + network.getValue(johnEmail)   + " should be 0987654321");
                System.out.println("\n Jane:    " + network.getValue(janeEmail)    + " should be 0987654321");
                System.out.println("\n Thomas:    " + network.getValue(tomEmail)    + " should be 135790246");
                System.out.println("\n Dirk:   " + network.getValue(dirkEmail)   + " should be 5556781212");
                System.out.println("\n Matthew:    " + network.getValue(matEmail)    + " should be 8007001234");
                System.out.println("\n Bob:    " + network.getValue(bobEmail)    + " should be 717123555");
                System.out.println("\n Charlie:   " + network.getValue(charlieEmail)   + " should be 6157771223");
                System.out.println("\n Jim:    " + network.getValue(jimEmail)    + " should be 9809991675");
                System.out.println("\n Mary:    " + network.getValue(maryEmail)    + " should be 9199268877");

	
                // Test contains
		System.out.println("\n\n\nTesting contains():\n");

		if ( network.contains("john@example.com") )
			System.out.println("\nJohn is in network - OK");
		else 
			System.out.println("Error in contains()");
		
		if ( network.contains("jane@example.com") )
			System.out.println("\nJane is in network - OK");
		else 
			System.out.println("Error in contains()");
		
		if ( network.contains("tom@example.com") )
			System.out.println("\nTom is in network - OK");
		else 
			System.out.println("Error in contains()");
		
		if (!network.contains("Bo"))
			System.out.println("\nBo is not in network - OK");
		else 
			System.out.println("Error in contains()");
                
		if (!network.contains("Henry"))
			System.out.println("\nHenry is not in network - OK");
		else 
			System.out.println("Error in contains()");
                
		if (!network.contains("Matthew"))
			System.out.println("\nMatthew is in network - OK");
		else 
			System.out.println("Error in contains()");

                if (!network.contains("Thomas"))
			System.out.println("\nThomas is in network - OK");
		else 
			System.out.println("Error in contains()");

                // Remove first item
		System.out.println("\n\n\nRemoving first item John - John's number is " +
		                   network.remove(johnEmail) + " should be 0987654321");
		System.out.println("\n\n\nRemoving second item Jane - Jane number is " +
		                   network.remove(janeEmail) + " should be 0987654321");
		System.out.println("\n\n\nRemoving third item Tom - Tom's number is " +
		                   network.remove(tomEmail) + " should be 135790246");

		System.out.println("\n" + network.getSize() + 
		              " (should be 7) items in dictionary, as follows:\n");
		network.displayProfiles();
		

	} // testDictionary
	
	public static void display(DictionaryInterface<String, UserProfile> dictionary)
	{
                Iterator<String> keyIterator   = dictionary.getKeyIterator();
                //     keyIterator<String> valueIterator = dictionary.getValueIterator();
                Iterator<UserProfile> valueIterator = dictionary.getValueIterator();
                while (keyIterator.hasNext() && valueIterator.hasNext()) {
                        System.out.println(keyIterator.next() + " : " + valueIterator.next());
                        System.out.println();
                }
	} // end display
}  // end Driver

