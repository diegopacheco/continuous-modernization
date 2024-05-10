### Build 
```bash
./mvnw clean install 
```
### Anti-Patterns

Here we have the implementation of a anti-patterns internal shared library wrapper.

Full list of anti-patterns:
* Internal Shared Library Wrapper: Such lib should never exist, we should just be using open source directly.
* Poor dependency management: We have libraries we dont need, like all AWS sdks for instance.
* Hard-Coded credentials: We have hard-coded credentials in the code.
* No tests: We have no tests for the library.
* No Observability: We dont know whats going on, there is no metrics, nothing, nada.
* No documentation: We have no documentation for the library.
* Bad support: You cannot google anything on this library.
* Performance: The connection is being open and closed on every send call.
* Hidding Bugs: The code is swallowing exceptions.
* Dead code: There are useless enums and classes we dont need.
* Unnecessary complexity: We have a lot of classes and interfaces that are not needed - like the delegation and callback.
* No Flexibility: The library is brick wall, there is no way to extend it or customize any of the behavior of the internal driver, literally hudding open source from engineers.
* Binary Coupling: The library introduce big frameworks like Spring, and is using a old version full of vulnerabilitites.
* Oppininated: The library is forcing Spring on the users, what happens is the consumers want to bump spring version? The library will be a blocker.
* Lack of attention to detail: The library is poorly written, poorly mantained. It's really downgrading open source.
* Waterfall projects: When migrations need to happen ,such library will get into the way and will need to be migrated first and them the other dependening libraries and services.

### Doing better

Do not build this kind of library, just leverage open source. Push the code to the services, allow teams to have autonomy and freedon at the edge instead of centalization. There is nothing wrong in code duplication as long as is not buisness rules. It's very easy to ignore problems and pretend it's okay - but it's not. 