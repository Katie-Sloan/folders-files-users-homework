package com.example.foldersfilesusers.components;

import com.example.foldersfilesusers.models.File;
import com.example.foldersfilesusers.models.Folder;
import com.example.foldersfilesusers.models.User;
import com.example.foldersfilesusers.repositories.FileRepository;
import com.example.foldersfilesusers.repositories.FolderRepository;
import com.example.foldersfilesusers.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    FolderRepository folderRepository;

    @Autowired
    FileRepository fileRepository;

    public DataLoader() {

    }

    public void run(ApplicationArguments args) {
        User ross = new User("Ross");
        userRepository.save(ross);
        User monica = new User("Monica");
        userRepository.save(monica);
        User chandler = new User("Chandler");
        userRepository.save(chandler);
        User joey = new User("Joey");
        userRepository.save(joey);
        User phoebe = new User("Phoebe");
        userRepository.save(phoebe);
        User rachel = new User("Rachel");
        userRepository.save(rachel);
        Folder friendsStuff = new Folder("Friends_stuff", ross);
        folderRepository.save(friendsStuff);
        Folder lifeAdmin = new Folder("Life_admin", monica);
        folderRepository.save(lifeAdmin);
        Folder importantBills = new Folder("Important_bills", ross);
        folderRepository.save(importantBills);
        Folder centralPerkReceipts = new Folder("Central_perk_receipts", monica);
        folderRepository.save(centralPerkReceipts);
        Folder songLyrics = new Folder("Song_lyrics", phoebe);
        folderRepository.save(songLyrics);
        Folder paleontology = new Folder("Paleontology", ross);
        folderRepository.save(paleontology);
        File listOfMeAndMyFriends = new File("List_of_me_and_my_friends", "txt", 500, friendsStuff);
        fileRepository.save(listOfMeAndMyFriends);
        File listOfOtherFriends = new File("List_of_other_friends", "txt", 400, friendsStuff);
        fileRepository.save(listOfOtherFriends);
        File shoppingList = new File("Shopping_list", "pages", 350, lifeAdmin);
        fileRepository.save(shoppingList);
        File holidayPlans = new File("Holiday_plans", "ppt", 150, lifeAdmin);
        fileRepository.save(holidayPlans);
        File choresList = new File("Chores_list", "java", 450, lifeAdmin);
        fileRepository.save(choresList);
        File coffee = new File("Coffee", "html", 100, centralPerkReceipts);
        fileRepository.save(coffee);
        ross.addFolder(friendsStuff);
        ross.addFolder(importantBills);
        ross.addFolder(paleontology);
        userRepository.save(ross);
        monica.addFolder(lifeAdmin);
        monica.addFolder(centralPerkReceipts);
        userRepository.save(monica);
        phoebe.addFolder(songLyrics);
        userRepository.save(phoebe);
        friendsStuff.addFile(listOfMeAndMyFriends);
        friendsStuff.addFile(listOfOtherFriends);
        folderRepository.save(friendsStuff);
        lifeAdmin.addFile(shoppingList);
        lifeAdmin.addFile(holidayPlans);
        lifeAdmin.addFile(choresList);
        folderRepository.save(lifeAdmin);
        centralPerkReceipts.addFile(coffee);
        folderRepository.save(centralPerkReceipts);
    }
}
