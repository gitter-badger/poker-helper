package org.bitbucket.hronom.poker.helper.core.poker.hands;

import org.bitbucket.hronom.poker.helper.core.cards.Card;
import org.bitbucket.hronom.poker.helper.core.cards.CardDenominationType;
import org.bitbucket.hronom.poker.helper.core.cards.CardSuitType;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by hronom on 20.06.15.
 */
public class HighCardTest {
    @Test
    public void testIsAcceptableCombination() throws Exception {
        Card cards[] = new Card[] {
            new Card(CardSuitType.DIAMOND, CardDenominationType.ACE),
            new Card(CardSuitType.DIAMOND, CardDenominationType.D10),
            new Card(CardSuitType.SPADE, CardDenominationType.D9),
            new Card(CardSuitType.CLUB, CardDenominationType.D5),
            new Card(CardSuitType.CLUB, CardDenominationType.D4)
        };

        HighCard highCard = new HighCard();
        assertTrue(highCard.isAcceptableCombination(cards));
    }
}