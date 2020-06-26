using Newtonsoft.Json;
using System.Collections.Generic;

namespace LifeHack.Domain.Models
{
    /// <summary>
    /// Encapsulates a Person data transfer object.
    /// </summary>
    public class Person : Entity
    {
        [JsonProperty("name")]
        public string Name { get; set; }
        [JsonProperty("goals")]
        public List<Goal> Goals { get; set; }
    }
}
