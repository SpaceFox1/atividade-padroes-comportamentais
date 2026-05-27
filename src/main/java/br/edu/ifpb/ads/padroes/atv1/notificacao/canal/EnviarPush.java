package br.edu.ifpb.ads.padroes.atv1.notificacao.canal;

import br.edu.ifpb.ads.padroes.atv1.notificacao.ICanalNotificacao;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;

public class EnviarPush implements ICanalNotificacao {

    @Override
    public void notificar(String txtNotificacao) {
        if (!SystemTray.isSupported()) {
            System.err.println("AVISO AVISO!!!!! Nova notificação: " + txtNotificacao);
            return;
        }

        try {
            SystemTray tray = SystemTray.getSystemTray();
            Image image = Toolkit.getDefaultToolkit().createImage(new byte[0]);
            TrayIcon trayIcon = new TrayIcon(image, "SuperDiscoSystem");
            trayIcon.setImageAutoSize(true);
            tray.add(trayIcon);
            trayIcon.displayMessage(
                    "SuperDiscoSystem",
                    txtNotificacao,
                    MessageType.INFO
            );

            new Thread(() -> {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException ignored) {}
                tray.remove(trayIcon);
            }).start();

        } catch (Exception e) {
            System.err.println("Vishe deu ruim, F: " + e.getMessage());
        }
    }
}