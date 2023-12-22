import React from 'react'
import TopPlayerLastWeek from './components/TopPlayerLastWeek'
import TopPlayerToWatch from './components/TopPlayerToWatch'

const Homepage = () => {
  return (
    <div class="main-div">
        <TopPlayerLastWeek/>
        <TopPlayerToWatch/>
    </div>
  )
}

export default Homepage