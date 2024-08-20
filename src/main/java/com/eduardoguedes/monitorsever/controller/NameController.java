package com.eduardoguedes.monitorsever.controller;

import com.eduardoguedes.monitorsever.service.RandomName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

@Controller
public class NameController {

  private final RandomName randomName;
  private final SimpMessagingTemplate messagingTemplate;

  @Autowired
  public NameController(RandomName nameService, SimpMessagingTemplate messagingTemplate) {
    this.randomName = nameService;
    this.messagingTemplate = messagingTemplate;
  }

  @Scheduled(fixedRate = 1000) // Envia a cada 5 segundos
  public void sendRandomNamePeriodically() {
    String randomName = this.randomName.drawName();
    messagingTemplate.convertAndSend("/topic/greetings", randomName);
  }


}
