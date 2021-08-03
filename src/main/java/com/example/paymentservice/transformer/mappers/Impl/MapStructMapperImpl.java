package com.example.paymentservice.transformer.mappers.Impl;

import com.example.paymentservice.dto.CardDto;
import com.example.paymentservice.entity.Card;
import com.example.paymentservice.transformer.mappers.IMapStructMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.List;

@Generated(
        value = "org.mapstruct.ap.MappingProcessor",
        date = "2021-03-11T19:21:44+0100",
        comments = "version: 1.4.2.Final, compiler: javac, environment: Java 13.0.2 (Oracle Corporation)"
)
@Component
public class MapStructMapperImpl implements IMapStructMapper {

    @Override
    public CardDto cardToCardDto(Card card) {
        if (card == null) {
            return null;
        }

        CardDto cardDto = new CardDto();

        cardDto.setId(card.getId());
        cardDto.setHolderName(card.getHolderName());
        cardDto.setCardNumber(card.getCardNumber());
        cardDto.setCardType(card.getCardType());
        cardDto.setCvv2(card.getCvv2());
        cardDto.setExpiredDate(card.getExpiredDate());
        cardDto.setStatus(card.getStatus());

        return cardDto;
    }

    public Card cardDtoToCard(CardDto cardDto){

        Card card = new Card();

        card.setId(cardDto.getId());
        card.setHolderName(cardDto.getHolderName());
        card.setCardNumber(cardDto.getCardNumber());
        card.setCardType(cardDto.getCardType());
        card.setCvv2(cardDto.getCvv2());
        card.setExpiredDate(cardDto.getExpiredDate());
        card.setStatus(cardDto.getStatus());

        return card;
    }

    /*@Override
    public List<CardDto> cardsToCardAllDto(List<Card> cards) {
        if (cards == null ) {
            return null;
        }

        List<CardDto> list = new ArrayList<CardDto>( cards.size() );
        for ( Card card : cards ) {
            list.add( authorToAuthorAllDto( author ) );
        }

        return list;
    }*/
}
