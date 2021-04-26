## Application description

  I created a Bank Management Application using Java. The architecture of the project permits scaling as the classes are distributed into packages and they have multiple possibilities of creating more by inheriting.
  
  For example, I only implemented Individual clients, leaving future possibility of implementing a legal person. There are also possibilities for implementing more services as they inherit for interfaces(online and offline services).
  
  
   
## Classes description
  
  The project consists in 20 classes and interfaces as following: 
 
-Account(Interface) is used as a base to create multiple types of accounts

-CurrentAccount(implements Account) is the account without interests or limit of transfers. It`s purpose is daily usage

-SavingsAccount(implements Account) is the account with interst rates and limited transfers

-AccountStatement(class) is a class used to get informations about an account and store them in a new object

-Card(class) is a class used to pair an Account Object with a Client object

-UnregisteredClient(class) represents a client without a card, it`s only ability is to access offline services

-IndividualClient(extends UnregisteredClient) is a client with at least one card registered at the bank(there are posibilities of implementing the legal person which would`ve complicated things too much)

-Bank(class) is an object which contains informations about a physical bank(location)

-OfflineService(interface) is used to implement services such as CurrencyExchange or deposits/withdrawals

-OnlineService(Interface) is used to implement services such as transfers or loans

-CurrencyExchange, Deposit and Withdrawal are all classes implementing OfflineService

-Transaction and Loan are classes implementing OnlineService

-Exceptions(Class) is an object which contains functions able to verify whether any object is valid or not(Eg. the length of CNP must be 24 and the name of someone must not be null)

-Pair(Class) is a class defined to pair clients with their informations about loan, the information is then stored in an ArrayList making Loans be accessible easier

-Main is the class filled with examples of the classes usage
