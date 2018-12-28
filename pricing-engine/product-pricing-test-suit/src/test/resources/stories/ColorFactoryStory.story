Feature:
provide list of products that have had a price reduction

Narrative:Create a hash table or similar device to translate basicColor to RGB

Scenario: Color Factory is a Color Factory with pre feed color and produces rbg and hex values for given color name
Given a Color factory exists
When a color name is feed to factory with name purple
Then a color hex value is returned by color factory

Scenario: Color Factory is a Color Factory with pre feed color and produces rbg and hex values for given color name
Given a Color factory exists
When a color name is feed to factory with name BLUE
Then a color rgb value is returned by color factory
