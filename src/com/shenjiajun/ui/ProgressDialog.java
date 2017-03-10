package com.shenjiajun.ui;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.DialogWrapper;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Logger;

/**
 * Created by shenjj on 2017/2/27.
 */
public class ProgressDialog extends DialogWrapper {
    private int maxImages = 0;
    private int currentIndex = 0;
    JPanel jPanel;
    JProgressBar jProgressBar;
    JTextArea reminderText;
    JTextArea linkText;
    private Logger logger = Logger.getLogger("ProgressDialog");

    public void setMaxImages(int maxImages) {
        this.maxImages = maxImages;
    }

    public void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
    }

    public ProgressDialog(@Nullable Project project) {
        super(project);
        init();
    }

    @Nullable
    @Override
    protected JComponent createCenterPanel() {
        jPanel = new JPanel();

        jProgressBar = new JProgressBar(SwingConstants.HORIZONTAL, 0, maxImages);
        jProgressBar.setString(currentIndex + "/" + maxImages);
        jProgressBar.setValue(currentIndex);
        jProgressBar.setStringPainted(true);

        reminderText = new JTextArea("每月500张图片限制已用完,请获取新KEY");
        reminderText.setVisible(false);
//        reminderText.setForeground(Color.CYAN);
        reminderText.setBackground(new Color(255, 255, 255, 0));

        jPanel.setLayout(new GridLayout(2, 1));
        jPanel.add(jProgressBar);
        jPanel.add(reminderText);
        return jPanel;
    }

    public void showError() {
        jProgressBar.setVisible(false);
//        reminderText.setText(errorStr);
        reminderText.setVisible(true);
    }

    public void revalidate() {
//        logger.info("repaint maxImages=" + maxImages + " currentIndex=" + currentIndex);
        jProgressBar.setString(currentIndex + "/" + maxImages);
        jProgressBar.setValue(currentIndex);

//        jProgressBar.revalidate();

    }

    @Override
    protected void init() {
        super.init();
    }

    @Override
    public void setTitle(@Nls(capitalization = Nls.Capitalization.Title) String title) {
        super.setTitle(title);
    }
}
