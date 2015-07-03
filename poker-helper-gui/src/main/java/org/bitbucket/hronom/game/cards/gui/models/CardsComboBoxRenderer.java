package org.bitbucket.hronom.game.cards.gui.models;

import org.bitbucket.hronom.poker.helper.core.cards.Card;
import org.bitbucket.hronom.poker.helper.core.cards.PokerDeck;

import java.awt.*;
import java.net.URL;
import java.util.HashMap;

import javax.swing.*;

/**
 * Created by hronom on 29.06.15.
 */
public class CardsComboBoxRenderer implements ListCellRenderer<Card> {
    private final HashMap<Card, ImageIcon> images = new HashMap<>();

    public CardsComboBoxRenderer() {
        for (int i = 0; i < PokerDeck.cards.size(); i++) {
            Card card = PokerDeck.cards.get(i);
            String fileName = "card" + getSuitTypeName(card) + getDenominationTypeName(card) +
                              ".png";
            ImageIcon imageIcon = getImageIcon(fileName);
            images.put(card, imageIcon);
        }

        ImageIcon imageIcon = getImageIcon("cardBack_blue4.png");
        images.put(null, imageIcon);
    }

    private ImageIcon getImageIcon(String fileName) {
        URL url = this.getClass().getClassLoader().getResource(
            "org/bitbucket/hronom/game/cards/gui/models/" + fileName
        );
        return new ImageIcon(url);
    }

    @Override
    public Component getListCellRendererComponent(
        JList<? extends Card> list, Card value, int index, boolean isSelected, boolean cellHasFocus
    ) {
        JLabel label = new JLabel();

        if (isSelected) {
            label.setBackground(list.getSelectionBackground());
            label.setForeground(list.getSelectionForeground());
        } else {
            label.setBackground(list.getBackground());
            label.setForeground(list.getForeground());
        }

        ImageIcon icon = images.get(value);
        label.setIcon(icon);

        if (value != null) {
            label.setText(
                "<html>" + value.suitType.name() + "<br><br>" + getDenominationTypeName(value) +
                "</html>"
            );
        } else {
            label.setText("No card");
        }
        label.setFont(list.getFont());

        return label;
    }

    private String getSuitTypeName(Card card) {
        switch (card.suitType) {
            case DIAMOND:
                return "Diamonds";
            case SPADE:
                return "Spades";
            case CLUB:
                return "Clubs";
            case HEART:
                return "Hearts";
        }
        return "";
    }

    private String getDenominationTypeName(Card card) {
        switch (card.denominationType) {
            case ACE:
                return "A";
            case D2:
                return "2";
            case D3:
                return "3";
            case D4:
                return "4";
            case D5:
                return "5";
            case D6:
                return "6";
            case D7:
                return "7";
            case D8:
                return "8";
            case D9:
                return "9";
            case D10:
                return "10";
            case JACK:
                return "J";
            case QUEEN:
                return "Q";
            case KING:
                return "K";
        }

        return "";
    }
}
