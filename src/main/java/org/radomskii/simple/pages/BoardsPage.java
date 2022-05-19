package org.radomskii.simple.pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.radomskii.simple.entities.Board;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
@Getter
public class BoardsPage extends AbstractBasePage {

    private SelenideElement header = $("div#header");
    private SelenideElement userIcon = $x("//span[contains(@style, '32px')]");
    private SelenideElement createNewBoardTile = $("div.board-tile.mod-add");

    public void createNewBoard(Board board) {
        createNewBoardTile.click();

    }
}
