package com.io;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WatchDir {
	public static void main(String[] args) throws IOException {

		Path path = Paths.get("C:/Users/fbg/");
		WatchService watchService = FileSystems.getDefault().newWatchService();
		path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);
		
		boolean done = false;
		while(!done){
			try{
				System.out.println("POLL");
				WatchKey watchKey = watchService.poll(5,TimeUnit.SECONDS);
				System.out.println("END POLL");
				if(watchKey!=null) {
					List<WatchEvent<?>> events = watchKey.pollEvents();
					for(WatchEvent event : events){
						if (event.kind().equals(StandardWatchEventKinds.ENTRY_CREATE)){
							done=true;
						}
					}
				}
			} catch(InterruptedException e){
				System.out.println("EXCEPTION");
				Thread.currentThread().interrupt();
			}
		}
	}

}
