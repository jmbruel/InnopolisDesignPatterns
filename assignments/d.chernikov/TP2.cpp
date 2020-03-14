/// Author: Denis Chernikov, especially for [S20] Design Patterns, Innopolis University.

#include <cassert>
#include <type_traits>

// The most basic implementation of a singleton pattern.
class trivial_singleton
{
    // Singleton should not be constructed outside of this scope.
    // Default constructor is private.
    trivial_singleton() {}

    // Put other private attributes and methods here...

public:
    // Singleton object is mutable here.
    // Return type should be `const trivial singleton&` to make it immutable.
    static trivial_singleton& get()
    {
        // This instance is single per all calls to this static method.
        static trivial_singleton instance;

        // The reference to that instance is returned.
        return instance;
    }

    // Put other public attributes and methods here...
};

// The most generic implementation.
// It uses inheritance for adding attributes and CRTP for less verbose code.
template <class T>
class singleton
{
protected:
    // Default constructor is accessible for descendants.
    singleton() noexcept = default;

    // Destruction should also be possible only to descendants.
    ~singleton() = default;

private:
    // Singleton should be non-copyable.
    singleton(const singleton&) noexcept = delete;
    singleton& operator=(const singleton&) noexcept = delete;

    // Singleton should be non-movable (just in case).
    singleton(singleton&&) noexcept = delete;
    singleton& operator=(singleton&&) noexcept = delete;

public:
    [[nodiscard]] static T& get() noexcept
    {
        static T instance;
        return instance;
    }
};

// Macro for easy default implementation of a mutable singleton.
#define SINGLETON(name, public_members, private_members) \
    struct name : singleton<name>                        \
    {                                                    \
        public_members;                                  \
    private:                                             \
        private_members;                                 \
        friend singleton<name>;                          \
        name() noexcept = default;                       \
        ~name() = default;                               \
    }

// Macro for easy default implementation of an immutable singleton.
#define CONST_SINGLETON(name, public_members, private_members) \
    struct name : singleton<const name>                        \
    {                                                          \
        public_members;                                        \
    private:                                                   \
        private_members;                                       \
        friend singleton<const name>;                          \
        name() noexcept = default;                             \
        ~name() = default;                                     \
    }

// Default implementations: empty singleton.
SINGLETON(empty_singleton,,);
CONST_SINGLETON(const_empty_singleton,,);

// Very basic static and unit tests.
static void test_singleton() noexcept
try
{
    SINGLETON(Universe, int i = 42,);

    //// CODE EQUIVALENT TO MACRO ABOVE (may be implemented by hands)
    //// Adding attributes via CRTP (see duplicating typename while inheriting?).
    // struct Universe : singleton<Universe>
    // {
    //     int i = 42;
    // private:
    //     // Important to allow access to the constructor by `singleton::get()`.
    //     friend singleton<Universe>;
    //     // Need to explicitly hide the constructor in descendant.
    //     Universe() = default;
    //     ~Universe() = default;
    // };

    // COMPILE-TIME CORRECTNESS CHECK
    // `is_default_constructible<T>` checks if, in a given out-of-class context,
    // the object of type `T` is default-constructible
    // (public default constructor is present).
    //
    // `is_default_constructible<T>::value` contains the value answering this
    // question (`true` or `false`).
    //
    // `is_default_constructible_v<T>` is a shorthand for `is_default_constructible<T>::value`.
    //
    // `std::` is the namespace where this pseudo-type lies.
    //
    // `!` negates the result of `is_default_constructible` request.
    //
    // `static_assert` checks if the expression is `true` at compile time.
    static_assert(!std::is_default_constructible_v<Universe>);
    static_assert(!std::is_copy_constructible_v<Universe>);
    static_assert(!std::is_move_constructible_v<Universe>);
    static_assert(!std::is_copy_assignable_v<Universe>);
    static_assert(!std::is_move_assignable_v<Universe>);
    static_assert(!std::is_destructible_v<Universe>);

    auto &i1 = Universe::get();
    auto &i2 = Universe::get();
    assert(&i1 == &i2 && "Locations in memory of both singleton referentes are not equal.");

    i1.i = 1;
    assert(i2.i == 1 && "Value is not the same in both singleton referentes.");
}
catch (...)
{
    assert(false && "Unexpected exception handled.");
}

int main(const int argc, const char *const *const argv)
{
    test_singleton();

    return 0;
}
