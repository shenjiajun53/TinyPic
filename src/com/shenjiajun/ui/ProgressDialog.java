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
    JProgressBar jProgressBar;
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

    protected ProgressDialog(@Nullable Project project, boolean canBeParent) {
        super(project, canBeParent);
        init();
    }

    protected ProgressDialog(@Nullable Project project, boolean canBeParent, @NotNull IdeModalityType ideModalityType) {
        super(project, canBeParent, ideModalityType);
        init();
    }

    protected ProgressDialog(@Nullable Project project, @Nullable Component parentComponent, boolean canBeParent, @NotNull IdeModalityType ideModalityType) {
        super(project, parentComponent, canBeParent, ideModalityType);
        init();
    }


    protected ProgressDialog(boolean canBeParent) {
        super(canBeParent);
        init();
    }

    @Nullable
    @Override
    protected JComponent createCenterPanel() {
        jProgressBar = new JProgressBar(SwingConstants.HORIZONTAL, 0, maxImages);
//        jProgressBar.addChangeListener(new ChangeListener() {
//            @Override
//            public void stateChanged(ChangeEvent e) {
//
//            }
//        });
        logger.info("maxImages=" + maxImages + " currentIndex=" + currentIndex);
        jProgressBar.setString(currentIndex + "/" + maxImages);
        jProgressBar.setValue(currentIndex);
        jProgressBar.setStringPainted(true);
//        jProgressBar.setBorderPainted(true);
//        jProgressBar.setForeground(Color.cyan);
//        jProgressBar.setBackground(Color.BLACK);

//        jProgressBar.show();
        return jProgressBar;
    }

    public void revalidate() {
        logger.info("repaint maxImages=" + maxImages + " currentIndex=" + currentIndex);
        jProgressBar.setString(currentIndex + "/" + maxImages);
        jProgressBar.setValue(currentIndex);

        jProgressBar.revalidate();
        jProgressBar.repaint();
    }

//    @Override
//    public void repaint() {
//        super.repaint();
//
//    }
//
//    @Nullable
//    @Override
//    protected ValidationInfo doValidate() {
//        ValidationInfo validationInfo = new ValidationInfo("111", jProgressBar);
//        return validationInfo;
//    }

//    @Nullable
//    @Override
//    public JComponent getPreferredFocusedComponent() {
//        return super.getPreferredFocusedComponent();
//    }

    @Override
    protected void init() {
        super.init();
    }

    @Override
    public void setTitle(@Nls(capitalization = Nls.Capitalization.Title) String title) {
        super.setTitle(title);
    }
}
