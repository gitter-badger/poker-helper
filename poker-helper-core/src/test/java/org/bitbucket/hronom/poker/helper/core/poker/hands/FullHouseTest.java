package org.bitbucket.hronom.poker.helper.core.poker.hands;

import org.bitbucket.hronom.poker.helper.core.cards.Card;
import org.bitbucket.hronom.poker.helper.core.cards.CardDenominationType;
import org.bitbucket.hronom.poker.helper.core.cards.CardSuitType;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by hronom on 20.06.15.
 */
public class FullHouseTest {

    @Test
    public void testIsAcceptableCombination() throws Exception {
        Card cards[] = new Card[] {
            new Card(CardSuitType.HEART, CardDenominationType.D10),
            new Card(CardSuitType.DIAMOND, CardDenominationType.D10),
            new Card(CardSuitType.SPADE, CardDenominationType.D10),
            new Card(CardSuitType.CLUB, CardDenominationType.D8),
            new Card(CardSuitType.HEART, CardDenominationType.D8)
        };

        FullHouse fullHouse = new FullHouse();
        assertTrue(fullHouse.isAcceptableCombination(cards));
    }
}