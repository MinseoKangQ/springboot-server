package com.server.sumnote.summary.service;

import io.github.flashvayne.chatgpt.service.ChatgptService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Component("summaryChatService")
public class ChatServiceImpl implements ChatService{

    private final ChatgptService chatgptService;

    @Override
    public String getChatResponse(String prompt) {

        String answerTmp = chatgptService.sendMessage(prompt);
        String answer = answerTmp.replace("\n", "");

        int index = answer.indexOf(':');

        if (index != -1) {
            answer = answer.substring(index + 1);

        } else {
            System.out.println(answer);
        }

        if (answer.charAt(0) == ' ') {
            answer = answer.trim();
        }

        return answer;
    }
}