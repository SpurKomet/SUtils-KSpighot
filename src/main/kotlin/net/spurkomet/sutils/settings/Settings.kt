package net.spurkomet.sutils.settings

object settings {
    var damageIndicator = false
    var position = false
    var move = false
    var gravestone = false
    var backpack = false

    object timer{
        var countdown = false
        var timer = false
        var isRun = false
        object time{
            var time = 0
            var sec = 0
            var min = 0
            var h = 0
        }
    }

    object soup{
        var soup = false
        var heal = 4
        var food = 5
        var sateration = 3
    }
}