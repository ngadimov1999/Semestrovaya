package com.classes;
import java.awt.*;
import java.io.File;
import javax.swing.JFileChooser;

import com.interfaces.PlayerInterface;

import jaco.mp3.player.MP3Player;

import static com.classes.ViewClass.listOfSongs;

/**
 * PlayerMethods implements methods from the interface PlayerInterface
 * A external library is imported for playing mp3 files
 * @author celepm
 */
public class PlayerMethods implements PlayerInterface{
	private File file;
	MP3Player mp3Player = new MP3Player();

	public File getFile() {  //геттер для файла
		return file;
	}

	public void setFile(File file) {  //сеттер для файлв))0)
		this.file = file;
	}

	public MP3Player getMp3Player() {  //геттер для мп3
		return mp3Player;
	}

	public void setMp3Player(MP3Player mp3Player) {  //сеттер для мп3
		this.mp3Player = mp3Player;
	}

	@Override
	public void pause() {  //пауза
		mp3Player.pause();
	}

	@Override
	public void stop() {  //стоп
		mp3Player.stop();
	}

	@Override
	public void play() {  //play
		mp3Player.play();
	}

	@Override
	public void browse() {  //метод для просматривания
		String userDir = System.getProperty("user.home"); //домашний каталог текущего вошедшего в систему пользователя
		JFileChooser fc = new JFileChooser(userDir); //инструмент JFileChooser, для выбора файлов и каталогов
		int status = fc.showOpenDialog(null); //Функция открытия диалогового окна «Открыть файл»
		
		if (status == JFileChooser.APPROVE_OPTION) {  //если выбрано утверждение(да, ок)
			file = fc.getSelectedFile();  //чтение выделенного файла
			mp3Player.stop();
			mp3Player = new MP3Player(file);
			mp3Player.addToPlayList(file);
			file = fc.getSelectedFile();
			listOfSongs.append(file.getName());
			listOfSongs.append("\n");
			System.out.println(file.getName());
			play();
			} else if (status == JFileChooser.CANCEL_OPTION) {
				System.out.println("Закрыто");
			}
	}

}
