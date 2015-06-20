package org.bitbucket.hronom.poker.helper.core.poker.hands;

import org.bitbucket.hronom.poker.helper.core.cards.Card;
import org.bitbucket.hronom.poker.helper.core.cards.CardDenominationType;

/**
 * Две пары/Две двойки/Два плюс два/допер (англ. two pairs): две пары карт, например: 8♣ 8♠ 4♥ 4♣
 */
public class TwoPair implements PokerHand {
    @Override
    public boolean isAcceptableCombination(Card[] cards) {
        if (!checkCards(cards)) {
            return false;
        }

        return true;
    }

    private boolean checkCards(Card[] cards) {
        CardDenominationType firstCardDenominationType = null;

        for (Card currentCard : cards) {
            int countOfCards = 0;
            if (currentCard != null) {
                for (Card checkCard : cards) {
                    if (checkCard != null) {
                        if (currentCard != checkCard) {
                            if (currentCard.denominationType == checkCard.denominationType &&
                                currentCard.denominationType != firstCardDenominationType) {
                                countOfCards++;
                            }
                        }
                    }
                }
            }

            if (countOfCards == 1 && firstCardDenominationType == null) {
                firstCardDenominationType = currentCard.denominationType;
            } else {
                return true;
            }
        }

        return false;
    }
}
