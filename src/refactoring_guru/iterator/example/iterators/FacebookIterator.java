package refactoring_guru.iterator.example.iterators;

import refactoring_guru.iterator.example.profile.Profile;
import refactoring_guru.iterator.example.social_networks.Facebook;

import java.util.ArrayList;
import java.util.List;

/**
 * EN: FacebookIterator is an implementation of the iterator for iterating over Facebook profiles.
 * It uses lazy loading to fetch friends or coworkers from the social network only when needed.
 *
 * RU: FacebookIterator - это реализация итератора для перебора профилей Facebook.
 * Он использует отложенную загрузку для получения друзей или коллег из социальной сети только при необходимости.
 */

public class FacebookIterator implements ProfileIterator {
    private Facebook facebook;
    private String type;
    private String email;
    private int currentPosition = 0;
    private List<String> emails = new ArrayList<>();
    private List<Profile> profiles = new ArrayList<>();

    /**
     * EN: Constructor for FacebookIterator. It initializes the iterator with the Facebook instance,
     * type of contacts to load, and the email of the starting profile.
     *
     * RU: Конструктор для FacebookIterator. Инициализирует итератор экземпляром Facebook,
     * типом контактов для загрузки и email начального профиля.
     *
     * @param facebook Facebook social network instance.
     * @param type     The type of contacts to iterate (friends, coworkers).
     * @param email    The email of the profile to start iteration from.
     */
    public FacebookIterator(Facebook facebook, String type, String email) {
        this.facebook = facebook;
        this.type = type;
        this.email = email;
    }

    /**
     * EN: Lazy loads the friends or coworkers of the profile by making a request to the Facebook network.
     * If already loaded, it does nothing.
     *
     * RU: Отложенно загружает друзей или коллег профиля, выполняя запрос к сети Facebook.
     * Если уже загружено, ничего не делает.
     */
    private void lazyLoad() {
        if (emails.size() == 0) {
            List<String> profiles = facebook.requestProfileFriendsFromFacebook(this.email, this.type);
            for (String profile : profiles) {
                this.emails.add(profile);
                this.profiles.add(null);
            }
        }
    }

    /**
     * EN: Checks if there are more profiles to iterate.
     *
     * RU: Проверяет, есть ли еще профили для итерации.
     *
     * @return true if there are more profiles, false otherwise.
     */
    @Override
    public boolean hasNext() {
        lazyLoad();
        return currentPosition < emails.size();
    }

    /**
     * EN: Returns the next profile in the iteration.
     * If the profile is not loaded yet, it requests the profile from Facebook.
     *
     * RU: Возвращает следующий профиль в итерации.
     * Если профиль еще не загружен, запрашивает его из Facebook.
     *
     * @return The next Profile instance.
     */
    @Override
    public Profile getNext() {
        if (!hasNext()) {
            return null;
        }

        String friendEmail = emails.get(currentPosition);
        Profile friendProfile = profiles.get(currentPosition);
        if (friendProfile == null) {
            friendProfile = facebook.requestProfileFromFacebook(friendEmail);
            profiles.set(currentPosition, friendProfile);
        }
        currentPosition++;
        return friendProfile;
    }

    /**
     * EN: Resets the iterator back to the start position.
     *
     * RU: Сбрасывает итератор на начальную позицию.
     */
    @Override
    public void reset() {
        currentPosition = 0;
    }
}
