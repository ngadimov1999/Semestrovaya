package com.classes;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author celepm
 * ViewClass содержит в себе GUI для mp3 плеера
 */
public class ViewClass extends JFrame {
	private JFrame frame; //оконное приложение
	public JTextField txtPlaying;  //позволяет выводить текст в UI
	public static JTextArea listOfSongs; //текстовое поле со списком треков
	PlayerMethods playerMethods = new PlayerMethods();

	/**
	 * Запуск приложения
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {   //ключевой момент программы, это функция, которая посылает
												// задание текущего потока на очередь к выполнению в главный поток
			public void run() {
				try {
					ViewClass window = new ViewClass();
					window.frame.setVisible(true); //?? делаем окно видимым
				} catch (Exception e) {
					e.printStackTrace();  //печать места, где произошло исключение
				}
			}
		});
	}

	/**
	 * Создание приложения
	 */
	public ViewClass() {
		initialize();
	}

	/**
	 * Инициализация содержимого в фрейме
	 */
	private void initialize() {
		frame = new JFrame();  //оконное приложение
		frame.setTitle("MP3");
		frame.getContentPane().setBackground(Color.BLACK);  //Обратиться к панели содержимого и сделать ее черной
		frame.setBounds(525, 300, 530, 243); //установить ее положение и размеры
		frame.setResizable(false); //запретить изменение размеров
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //при закрытии окна закрывается и приложение
		frame.getContentPane().setLayout(null); //компоновщик контейнера? Определяет менеджера размещения
				
		/**
		 * кнопка воспроизведения с помощью метода из PlayMethod
		 */
		JButton btnPlay = new JButton("Play");    //кнопка play
		btnPlay.addActionListener(new ActionListener() {   //ActionListener - механизм обратного вызова
			public void actionPerformed(ActionEvent e) {
				playerMethods.play();
				txtPlaying.setText("Playing: " + playerMethods.getFile().getName()); //вывод TextField
			}
		});
		btnPlay.setBackground(Color.WHITE); //цвет кнопки
		btnPlay.setIcon(new ImageIcon(ViewClass.class.getResource("/resources/play.jpg"))); //фото кнопки
		btnPlay.setBounds(6, 48, 117, 41); //расположение кнопки
		frame.getContentPane().add(btnPlay); //добавить на панель кнопку
		
		/**
		 * кнопка паузы с помощью метода из PlayMethod
		 */
		JButton btnPause = new JButton("Пауза");
		btnPause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerMethods.pause();
				txtPlaying.setText("Пауза: " + playerMethods.getFile().getName());
			}
		});
		btnPause.setBackground(Color.WHITE);
		btnPause.setIcon(new ImageIcon(ViewClass.class.getResource("/resources/pause.jpg")));
		btnPause.setBounds(135, 48, 117, 41);
		frame.getContentPane().add(btnPause);
		
		/**
		 * кнопка просмотреть с помощью метода из PlayMethod
		 */
		JButton btnBrowse = new JButton("Browse");
		
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerMethods.browse();
				txtPlaying.setText("Играет: " + playerMethods.getFile().getName());
			}
		});
		btnBrowse.setBackground(Color.WHITE);
		btnBrowse.setIcon(new ImageIcon(ViewClass.class.getResource("/resources/browse.jpg")));
		btnBrowse.setBounds(393, 48, 117, 41);
		frame.getContentPane().add(btnBrowse);
		
		/**
		 * кнопка стоп для остановки с помощью метода из методов проигрывателя
		 */
		JButton btnStop = new JButton("Стоп");
		btnStop.setBackground(Color.WHITE);
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerMethods.stop();
				txtPlaying.setText("Остановилась: " + playerMethods.getFile().getName());
			}
		});
		btnStop.setBounds(264, 48, 117, 41);
		btnStop.setIcon(new ImageIcon(ViewClass.class.getResource("/resources/stop.jpg")));
		frame.getContentPane().add(btnStop);
		
		/**
		 * настройка текста для текстового поля
		 */
		txtPlaying = new JTextField();
		txtPlaying.setHorizontalAlignment(SwingConstants.CENTER);
		txtPlaying.setEditable(false);
		txtPlaying.setBounds(5, 14, 505, 25);
		txtPlaying.setText("Добро пожаловать в MusicPlayer!");
		frame.getContentPane().add(txtPlaying);
		txtPlaying.setColumns(10);

		listOfSongs = new JTextArea();
		listOfSongs.setBounds(5,100,500,100);
		listOfSongs.setSize(505, 100);
		listOfSongs.setEditable(false);
		frame.getContentPane().add(listOfSongs);

	}
}
