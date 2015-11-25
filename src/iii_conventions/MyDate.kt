package iii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) {
    operator fun compareTo(other: MyDate) = when {
        this.year != other.year -> this.year - other.year
        this.month != other.month -> this.month - other.month
        else -> this.dayOfMonth - other.dayOfMonth
    }
}

operator fun MyDate.rangeTo(other: MyDate) = DateRange(this, other)

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

class DateRange(val start: MyDate, val endInclusive: MyDate) : Iterable<MyDate> {
    operator fun contains(date: MyDate) = date >= start && date <= endInclusive

    override operator fun iterator(): Iterator<MyDate> = object : Iterator<MyDate> {

        var current = start

        override fun hasNext() = current <= endInclusive

        override fun next() : MyDate {
            val result = current
            current = current.nextDay()
            return result
        }
    }
}
