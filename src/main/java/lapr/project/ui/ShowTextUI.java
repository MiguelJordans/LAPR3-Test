package lapr.project.ui;

import org.apache.maven.surefire.shade.org.apache.commons.lang3.StringUtils;

public class ShowTextUI implements Runnable {
    private final String text;

    public ShowTextUI(String text) {
        if (StringUtils.isBlank(text)) {
            throw new IllegalArgumentException("ShowTextUI does not support null or empty text");
        } else {
            this.text = text;
        }
    }

    public void run() {
        System.out.println("\n");
        System.out.println(this.text);
        System.out.println("\n");
    }
}