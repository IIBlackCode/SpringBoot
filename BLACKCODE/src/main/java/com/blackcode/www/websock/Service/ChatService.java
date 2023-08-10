package com.blackcode.www.websock.Service;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import com.blackcode.www.websock.Dto.ChatRoom;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

  @Slf4j
  @RequiredArgsConstructor
  @Service
  public class ChatService {
      private final ObjectMapper objectMapper;
      private Map<String, ChatRoom> chatRooms;
        
      @PostConstruct
      private void init() {
          chatRooms = new LinkedHashMap<>();
      }
        
      public List<ChatRoom> findAllRoom() {
    	  log.info(chatRooms.values().toString());
          return new ArrayList<>(chatRooms.values());
      }
        
      public ChatRoom findRoomById(String roomId) {
    	  ChatRoom chatRoom = chatRooms.get(roomId.replaceAll(",", ""));
          return chatRoom;
      }
        
      public ChatRoom createRoom(String name) {
          String randomId = UUID.randomUUID().toString();
          ChatRoom chatRoom = ChatRoom.builder()
                  .roomId(randomId)
                  .name(name)
                  .build();
          chatRooms.put(randomId, chatRoom);
          log.info(chatRoom.toString());
          return chatRoom;
      }
        
      public <T> void sendMessage(WebSocketSession session, T message) {
          try{
              session.sendMessage(new TextMessage(objectMapper.writeValueAsString(message)));
          } catch (IOException e) {
              log.error(e.getMessage(), e);
          }
      }
  }