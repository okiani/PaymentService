package com.example.paymentservice.transformer.mappers;

import com.example.paymentservice.dto.CardDto;
import com.example.paymentservice.entity.Card;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(
        componentModel = "spring"
)
public interface IMapStructMapper {
//    BookSlimDto bookToBookSlimDto(Book book);

//    BookDto bookToBookDto(Book book);
    CardDto cardToCardDto(Card card);

//    AuthorDto authorToAuthorDto(Author author);

//    AuthorAllDto authorToAuthorAllDto(Author author);
//    CardAllDto cardToCardAllDto(Card card);

//    List<AuthorAllDto> authorsToAuthorAllDtos(List<Author> authors);
//    List<CardDto> cardsToCardAllDto(List<Card> cards);

//    UserGetDto userToUserGetDto(User user);

//    User userPostDtoToUser(UserPostDto userPostDto);
}

