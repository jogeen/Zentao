package icu.jogeen.zentao.service;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import org.jdom.Element;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @Author jogeen
 * @Date 14:28 2020/6/24
 * @Description
 */

@State(
        name = "PersistentState",
        storages = {@Storage(
                value = "zentao-login.xml"
        )}
)
public class PersistentState implements PersistentStateComponent<Element> {

    private static PersistentState persistentState;

    private String url;

    private String username;

    private String password;

    public PersistentState() {
    }

    public static PersistentState getInstance() {
        if (persistentState == null) {
            persistentState = ServiceManager.getService(PersistentState.class);
        }

        return persistentState;
    }

    @Nullable
    @Override
    public Element getState() {
        Element element = new Element("PersistentState");
        element.setAttribute("url", url);
        element.setAttribute("username", username);
        element.setAttribute("password", password);
        return element;
    }

    @Override
    public void loadState(@NotNull Element element) {
        this.url = element.getAttributeValue("url");
        String usernameStr = element.getAttributeValue("username");
        this.username = usernameStr;

        String passwordStr = element.getAttributeValue("password");
        this.password = passwordStr;

    }

    public String getUrl() {
        return url;
    }

    public PersistentState setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public PersistentState setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public PersistentState setPassword(String password) {
        this.password = password;
        return this;
    }
}
