package ro.giohnny.springaiimage.services;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.image.ImageModel;
import org.springframework.ai.image.ImageOptionsBuilder;
import org.springframework.ai.image.ImagePrompt;
import org.springframework.stereotype.Service;
import ro.giohnny.springaiimage.model.Question;

import java.util.Base64;

/**
 * Created by jt, Spring Framework Guru.
 */
@RequiredArgsConstructor
@Service
public class OpenAIServiceImpl implements OpenAIService {

    final ImageModel imageModel;

    @Override
    public byte[] getImage(Question question) {
        var options = ImageOptionsBuilder.builder()
                .height(1024).width(1024)
                .responseFormat("b64_json")
                //.withModel("dall-e-2")
                .model("dall-e-3")
                .build();

        ImagePrompt imagePrompt = new ImagePrompt(question.question(), options);
        var imageResponse = imageModel.call(imagePrompt);

        return Base64.getDecoder().decode(imageResponse.getResult().getOutput().getB64Json());
    }
}
