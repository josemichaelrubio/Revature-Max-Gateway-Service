package dev.revaturemax.repository;

import com.sun.javaws.exceptions.InvalidArgumentException;
import dev.revaturemax.model.UserAuth;
import org.junit.After;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;

public class UserAuthRepositoryTest {

    @Autowired
    UserAuthRepository userAuthRepository;

//    @Before
//    public void testSetup(){
//        for(int i = 0; i < 5; i++){
//            userAuthRepository.save(new UserAuth("user" + i, "pw"));
//        }
//    }
//
//    @After
//    public void testTearDown(){
//        for(int i = 0; i < 5; i++){
//            try{
//                userAuthRepository.delete(new UserAuth("user" + i,"pw"));
//            } catch(InvalidArgumentException e){
//
//            }
//        }
//    }

    public void testFindByUsername(){

    }
}
