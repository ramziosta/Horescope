package com.revature.services;

import com.revature.models.User;
import com.revature.repos.UserRepo;

import java.util.List;

public class UserService {

   private final UserRepo userRepo;

   public UserService() {
      userRepo = new UserRepo();
   }

   public UserService(UserRepo userRepo) {
      this.userRepo = userRepo;
   }

   // create
   public int create(User user) {
      return userRepo.create(user);
   }

   // read all
   public List<User> getAllUsers() {
      return userRepo.getAll();
   }

   // read byID

   public User getById(int id) {
      return userRepo.getById(id);
   }

   // update

   public User updateUser(User user) {
      return userRepo.update(user);
   }

   // delete
   public boolean deleteUser(User user) {
      return userRepo.delete(user);
   }

   // logins
 public User login(User user) {
      return userRepo.login(user);

   }

   // logout
 public User logout(User user) {
      return userRepo.logout(user);

   }

}