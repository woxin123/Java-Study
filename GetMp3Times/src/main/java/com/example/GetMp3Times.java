package com.example;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.AudioDevice;
import javazoom.jl.player.Player;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.audio.mp3.MP3AudioHeader;
import org.jaudiotagger.audio.mp3.MP3File;
import org.jaudiotagger.tag.TagException;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class GetMp3Times {
    public static void main(String[] args) throws JavaLayerException, IOException, CannotReadException, ReadOnlyFileException, InvalidAudioFrameException, TagException {
        System.out.println(new GetMp3Times().getMp3Times());
    }

    public int getMp3Times() throws IOException, JavaLayerException, TagException, ReadOnlyFileException, CannotReadException, InvalidAudioFrameException {
        /*BufferedInputStream buffer = new BufferedInputStream(new FileInputStream("\u202AC:\\Users\\mengchen\\Music\\黑崎子 - 崇拜(Live)（Cover 林俊杰）.mp3"));
        Player player = new Player(buffer);
        player.play();*/
        int length;
        MP3File mp3File = (MP3File) AudioFileIO.read(new File("C:\\Users\\mengchen\\Music\\黑崎子 - 崇拜(Live)（Cover 林俊杰）.mp3"));
        MP3AudioHeader audioHeader = (MP3AudioHeader) mp3File.getAudioHeader();

        length = audioHeader.getTrackLength();

        return length;
    }
}
