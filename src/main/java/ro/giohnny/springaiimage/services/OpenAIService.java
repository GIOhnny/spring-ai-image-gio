package ro.giohnny.springaiimage.services;


import ro.giohnny.springaiimage.model.Question;


/**
 * Created by jt, Spring Framework Guru.
 */
public interface OpenAIService {

    byte[] getImage(Question question);
}
