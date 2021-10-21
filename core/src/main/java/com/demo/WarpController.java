package com.demo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Json;
import com.shephertz.app42.gaming.multiplayer.client.s2.WarpClient;
import com.shephertz.app42.gaming.multiplayer.client.s2.command.WarpResponseResultCode;
import com.shephertz.app42.gaming.multiplayer.client.s2.events.AllRoomsEvent;
import com.shephertz.app42.gaming.multiplayer.client.s2.events.AllUsersEvent;
import com.shephertz.app42.gaming.multiplayer.client.s2.events.ChatEvent;
import com.shephertz.app42.gaming.multiplayer.client.s2.events.ConnectEvent;
import com.shephertz.app42.gaming.multiplayer.client.s2.events.LiveRoomInfoEvent;
import com.shephertz.app42.gaming.multiplayer.client.s2.events.LiveUserInfoEvent;
import com.shephertz.app42.gaming.multiplayer.client.s2.events.LobbyData;
import com.shephertz.app42.gaming.multiplayer.client.s2.events.MatchedRoomsEvent;
import com.shephertz.app42.gaming.multiplayer.client.s2.events.MoveEvent;
import com.shephertz.app42.gaming.multiplayer.client.s2.events.RoomData;
import com.shephertz.app42.gaming.multiplayer.client.s2.events.RoomEvent;
import com.shephertz.app42.gaming.multiplayer.client.s2.events.UpdateEvent;
import com.shephertz.app42.gaming.multiplayer.client.s2.listener.ChatRequestListener;
import com.shephertz.app42.gaming.multiplayer.client.s2.listener.ConnectionRequestListener;
import com.shephertz.app42.gaming.multiplayer.client.s2.listener.LobbyRequestListener;
import com.shephertz.app42.gaming.multiplayer.client.s2.listener.NotifyListener;
import com.shephertz.app42.gaming.multiplayer.client.s2.listener.RoomRequestListener;
import com.shephertz.app42.gaming.multiplayer.client.s2.listener.TurnBasedRoomListener;
import com.shephertz.app42.gaming.multiplayer.client.s2.listener.ZoneRequestListener;

import java.util.HashMap;

public class WarpController implements ConnectionRequestListener, ZoneRequestListener, RoomRequestListener, TurnBasedRoomListener, NotifyListener, ChatRequestListener {
    private WarpClient client;
    public WarpController() throws Exception{
        WarpClient.initialize("897b0193-4ee4-4963-8","localhost");
        client=WarpClient.getInstance();
        client.addConnectionRequestListener(this);
        client.addZoneRequestListener(this);
        client.addRoomRequestListener(this);
        client.addNotificationListener(this);
    }

    public void connect(String userName){
        client.connectWithUserName(userName,"");
    }

    public void joinRoom(){
        HashMap<String,Object> properties=new HashMap<>();
        properties.put("type","demo");
        properties.put("version","1");
        client.joinRoomWithProperties(properties);
    }

    @Override
    public void onConnectDone(ConnectEvent connectEvent, String s) {
        Gdx.app.error("onConnectDone",new Json().prettyPrint(connectEvent));

        if (connectEvent.getResult()==WarpResponseResultCode.SUCCESS){
            joinRoom();
        }
    }

    @Override
    public void onDisconnectDone(ConnectEvent connectEvent) {

    }

    @Override
    public void onInitUDPDone(byte b) {

    }

    @Override
    public void onSubscribeRoomDone(RoomEvent roomEvent) {

    }

    @Override
    public void onUnSubscribeRoomDone(RoomEvent roomEvent) {

    }

    @Override
    public void onJoinRoomDone(RoomEvent roomEvent, String s) {
        Gdx.app.error("onJoinRoomDone",new Json().prettyPrint(roomEvent));

        if (roomEvent.getResult()== WarpResponseResultCode.SUCCESS){
        }else {
            HashMap<String,Object> properties=new HashMap<>();
            properties.put("type","demo");
            properties.put("state","Running");
            properties.put("version","1");
            client.createRoom("room1","234",5,properties);
        }
    }

    @Override
    public void onLeaveRoomDone(RoomEvent roomEvent) {

    }

    @Override
    public void onGetLiveRoomInfoDone(LiveRoomInfoEvent liveRoomInfoEvent) {

    }

    @Override
    public void onSetCustomRoomDataDone(LiveRoomInfoEvent liveRoomInfoEvent) {

    }

    @Override
    public void onUpdatePropertyDone(LiveRoomInfoEvent liveRoomInfoEvent, String s) {

    }

    @Override
    public void onLockPropertiesDone(byte b) {

    }

    @Override
    public void onUnlockPropertiesDone(byte b) {

    }

    @Override
    public void onRPCDone(byte b, String s, Object o) {

    }

    @Override
    public void onDeleteRoomDone(RoomEvent roomEvent, String s) {

    }

    @Override
    public void onGetAllRoomsDone(AllRoomsEvent allRoomsEvent) {

    }

    @Override
    public void onCreateRoomDone(RoomEvent roomEvent, String s) {
        Gdx.app.error("onCreateRoomDone",new Json().prettyPrint(roomEvent));
        if (roomEvent.getResult()==WarpResponseResultCode.SUCCESS){
            client.joinRoom(roomEvent.getData().getId());
        }
    }

    @Override
    public void onGetOnlineUsersDone(AllUsersEvent allUsersEvent) {

    }

    @Override
    public void onGetLiveUserInfoDone(LiveUserInfoEvent liveUserInfoEvent) {

    }

    @Override
    public void onSetCustomUserDataDone(LiveUserInfoEvent liveUserInfoEvent) {

    }

    @Override
    public void onGetMatchedRoomsDone(MatchedRoomsEvent matchedRoomsEvent) {

    }

    @Override
    public void onSendChatDone(byte b, String s) {

    }

    @Override
    public void onSendPrivateChatDone(byte b, String s) {

    }

    @Override
    public void onRoomCreated(RoomData roomData) {

    }

    @Override
    public void onRoomDestroyed(RoomData roomData) {

    }

    @Override
    public void onUserLeftRoom(RoomData roomData, String s) {

    }

    @Override
    public void onUserJoinedRoom(RoomData roomData, String s) {

    }

    @Override
    public void onUserLeftLobby(LobbyData lobbyData, String s) {

    }

    @Override
    public void onUserJoinedLobby(LobbyData lobbyData, String s) {

    }

    @Override
    public void onChatReceived(ChatEvent chatEvent) {

    }

    @Override
    public void onPrivateChatReceived(String s, String s1) {

    }

    @Override
    public void onUpdatePeersReceived(UpdateEvent updateEvent) {

    }

    @Override
    public void onUserChangeRoomProperty(RoomData roomData, String s, HashMap<String, Object> hashMap, HashMap<String, String> hashMap1) {

    }

    @Override
    public void onMoveCompleted(MoveEvent moveEvent) {

    }

    @Override
    public void onGameStarted(String s, String s1, String s2) {

    }

    @Override
    public void onGameStopped(String s, String s1) {

    }

    @Override
    public void onUserPaused(String s, boolean b, String s1) {

    }

    @Override
    public void onUserResumed(String s, boolean b, String s1) {

    }

    @Override
    public void onSendMoveDone(byte b, String s) {

    }

    @Override
    public void onStartGameDone(byte b, String s) {

    }

    @Override
    public void onStopGameDone(byte b, String s) {

    }

    @Override
    public void onGetMoveHistoryDone(byte b, MoveEvent[] moveEvents) {

    }
}
