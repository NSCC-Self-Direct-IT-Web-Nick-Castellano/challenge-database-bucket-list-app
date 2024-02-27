/*
Copyright (C) 2022 Roy Watson

Permission is hereby granted, free of charge, to any person obtaining a copy of this
software and associated documentation files (the "Software"), to deal in the Software
without restriction, including without limitation the rights to use, copy, modify, merge,
publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons
to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies
or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE
FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE
OR OTHER DEALINGS IN THE SOFTWARE.
*/
package com.delasystems.androidcomposescaffoldnav.navigation

sealed class NavDestinations(val route: String) {
    object SearchScreen : NavDestinations("searchscreen")
    object SearchScreen2 : NavDestinations("searchscreen2")
    object SearchScreen3 : NavDestinations("searchscreen3")

    object HistoryScreen : NavDestinations("historyscreen")
    object HistoryScreen2 : NavDestinations("historyscreen2")
    object HistoryScreen3 : NavDestinations("historyscreen3")

    object FavoritesScreen : NavDestinations("favoritesscreen")
    object FavoritesScreen2 : NavDestinations("favoritesscreen2")
    object FavoritesScreen3 : NavDestinations("favoritesscreen3")
}

val SearchScreenList = listOf<String>(
    NavDestinations.SearchScreen.route,
    NavDestinations.SearchScreen2.route,
    NavDestinations.SearchScreen3.route
)

val HistoryScreenList = listOf<String>(
    NavDestinations.HistoryScreen.route,
    NavDestinations.HistoryScreen2.route,
    NavDestinations.HistoryScreen3.route
)

val FavoritesScreenList = listOf<String>(
    NavDestinations.FavoritesScreen.route,
    NavDestinations.FavoritesScreen2.route,
    NavDestinations.FavoritesScreen3.route
)
