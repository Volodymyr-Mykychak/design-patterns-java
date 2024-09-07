package refactoring_guru.iterator.example.social_networks;

import refactoring_guru.iterator.example.iterators.ProfileIterator;

/**
 * EN: SocialNetwork defines the interface for creating iterators that allow
 * iterating over friends and coworkers of a profile.
 *
 * RU: SocialNetwork определяет интерфейс для создания итераторов, которые позволяют
 * перебирать друзей и коллег профиля.
 */
public interface SocialNetwork {
    ProfileIterator createFriendsIterator(String profileEmail);

    ProfileIterator createCoworkersIterator(String profileEmail);
}
