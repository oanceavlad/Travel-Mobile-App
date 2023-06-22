package com.example.travelapp

object SetData {
    fun setPlaces():List<PlaceData> {
        var placeList = mutableListOf<PlaceData>()

        placeList.add(
            PlaceData(
                1,
                "South Beach",
                "white sand, art",
                "Glamorous hotels, clubs and restaurants converge in South Beach, but the American Riviera is most famous for its Art Deco vibe and two miles of white sand. Rack up Instagram likes by the 35 bright and funky lifeguard towers at one of the most popular beaches, and rent a DecoBike to explore the Art Deco Historic District’s 800 landmarks built from 1923 to 1943. Called the grand dame of Art Deco design, the Raleigh hotel has been a hot spot since 1940.",
                "Miami, Florida",
                "3/5"
            )
        )
        placeList.add(
            PlaceData(
                2,
                "Swiss Alps",
                "dynamic landscapes",
                "The dramatic peaks of Dammastock and the snow-clad majestic summit of Matterhorn have always amazed and left hikers spellbound with its astonishing beauty. Matterhorn is 10th tallest amongst the several mountains of the world with a distinct feature of a well-defined pyramid shape. It is one of the most active fold mountains of the world and is featured on the world famous Toblerone Chocolate as its logo. The slopes of the Switzerland mountains are famous for the skiing and snowboarding activities. This is amongst the famous mountains in the world.",
                "Switzerland",
                "4/5"
            )
        )
        placeList.add(
            PlaceData(
                3,
                "Whistler Blackcomb",
                "skiing, snowboarding",
                "Now part of Vail Resorts group, Whistler Blackcomb combines the superb terrain of two mountains to make it Canada's premier ski resort and the largest winter sports area in North America. The combined skiable terrain offers more than 200 runs accessed by 37 lifts. One of these, the three-kilometer-plus PEAK 2 PEAK gondola joins the two mountaintops and is the world's longest unsupported lift span.",
                "Canada",
                "5/5"
            )
        )
        placeList.add(
            PlaceData(
                4,
                "Pompano Beach",
                "fishing resort",
                "Bermuda is one of the most emblematic places in terms of sport fishing in the world; in fact, it is considered one of the best spots to fish the Blue Marlin. There are three types of fishing available to visitors: Deep Sea Fishing, Reef Fishing, and Shoreline Fishing. The latter is practiced from either a dock, beach or land.",
                "Bermuda",
                "4/5"
            )
        )
        placeList.add(
            PlaceData(
                5,
                "Thai Square Spa",
                "relax, peace",
                "With rich decor (silks, gold finishes and sculptures) this day spa on Northumberland Avenue is an opulent oasis of calm just a (hot) stone’s throw from Trafalgar Square. For less than 50 smackers visitors can enjoy the spa’s Sen Space for an hour, which includes a sauna, steam room, jacuzzi and ice fountains. Treatment-wise, £75 will get you a signature body scrub, whilst top-dollar treatments cost well over £200. Besides a long list of beauty therapies, Thai Square has a solid selection of male-specific treatments, such as a collagen facial and hot towel facial.",
                "Central London",
                "2/5"
            )
        )
        placeList.add(
            PlaceData(
                6,
                "Waterfall Safari",
                "sea",
                "With Loskop Dam Nature Reserve reachable in 14 km, Waterfall Safari Lodge provides accommodation, a restaurant, an outdoor swimming pool, a garden and a bar. Free WiFi is provided. Some of the units include a satellite TV, a fully equipped kitchen with a fridge, and a private bathroom with a shower and free toiletries. A barbecue is available on site and both hiking and cycling can be enjoyed within close proximity of the lodge. Loskop Dam is 9.4 km from Waterfall Safari Lodge. The nearest airport is Secunda Airfield Airport, 175 km from the accommodation.",
                "South Africa",
                "5/5"
            )
        )
        placeList.add(
            PlaceData(
                7,
                "Louvre Museum",
                "art, beauty",
                "The Louvre is home to more than half a million works. At any one time 35,000 of them are on display. This magnificent museum is the most important symbol of the cultural influence of France through the centuries. That's why so many millions of people flock to The Louvre from around the world, making it the most visited art museum on earth. On your visit, you will experience first hand the finest works of art created by the most celebrated artists. Leonardo's inscrutable 'Mona Lisa' is prime among them, the most famous painting there is.",
                "Paris, France",
                "5/5"
            )
        )
        placeList.add(
            PlaceData(
                8,
                "Maggie Daley Park",
                "ice skating, fun",
                "All around the world there are extraordinary ice-skating rinks that will satiate your need for exercise and architecture. One of them is Maggie Daley Park. It only opened in 2014, but Chicago’s downtown skating ribbon has already become a central fixture in the city’s winter schedule. Designed as part of the Maggie Daley urban park by architect Michael van Valkenburgh, it is a rolling loop of ice that not only provides a skating challenge but also extraordinary views of Chicago’s shimmering skyline.",
                "Chicago",
                "5/5"
            )
        )

    return placeList
    }
}